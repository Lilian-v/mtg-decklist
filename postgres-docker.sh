#!/bin/sh

init() {
	echo "creating docker volume postgres-mtg-decklist"
	docker volume create postgres-mtg-decklist
}

purge() {
	echo "removing docker volume postgres-mtg-decklist"
	docker volume rm postgres-mtg-decklist
}

start() {
	echo "starting postgres port 5435"
	docker run --name postgres_mtg_decklist -e POSTGRES_USER=mtg_decklist -e POSTGRES_PASSWORD=azerty123456 \
  -e POSTGRES_DB=mtg_decklist -v postgres-mtg-decklist:/var/lib/postgresql/data -p 5435:5432 -d postgres:16.0
}

stop() {
	echo "stopping postgres"
	docker stop postgres_mtg_decklist
	docker container rm postgres_mtg_decklist
}

psql() {
	docker exec -it postgres_mtg_decklist psql -U mtg_decklist
}


case "$1" in
	start)
		start
		;;
	stop)
		stop
		;;
	init)
		init
		;;
	purge)
		purge
		;;
	psql)
		psql
		;;
	*)
		echo "Usage: $0 {|start|stop|init|purge|psql}"
		;;
esac
