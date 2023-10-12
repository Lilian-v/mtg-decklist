#!/bin/sh

start_springboot() {
	mvn clean spring-boot:run -Drun.jvmArguments="-Xms128m -Xmx4g"
}

init_postgres() {
	echo "creating docker volume postgres-mtg-decklist"
	docker volume create postgres-mtg-decklist
}

purge_postgres() {
	echo "removing docker volume postgres-mtg-decklist"
	docker volume rm postgres-mtg-decklist
}

start_postgres() {
	if [ "$( docker container inspect -f '{{.State.Running}}' postgres_mtg_decklist )" = "true" ]; then
		echo "postgres already running"
	else
		docker container rm postgres_mtg_decklist
		echo "starting postgres port 5435"
		docker run --name postgres_mtg_decklist -e POSTGRES_USER=mtg_decklist -e POSTGRES_PASSWORD=azerty123456 \
		  -e POSTGRES_DB=mtg_decklist -v postgres-mtg-decklist:/var/lib/postgresql/data -p 5435:5432 -d postgres:16.0
	fi
}

stop_postgres() {
	echo "stopping postgres"
	docker stop postgres_mtg_decklist
	docker container rm postgres_mtg_decklist
}

psql() {
	docker exec -it postgres_mtg_decklist psql -U mtg_decklist
}


case "$1" in
	start)
		start_postgres
		start_springboot
		;;
	stop)
		stop_postgres
		;;
	init)
		init_postgres
		;;
	purge)
		stop_postgres
		purge_postgres
		;;
	psql)
		psql
		;;
	*)
		echo "Usage: $0 {|start|stop|init|purge|psql}"
		;;
esac
