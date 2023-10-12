package fr.livar.mtg.mtgdecklist.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.livar.mtg.mtgdecklist.persistence.model.Symbol;
import fr.livar.mtg.mtgdecklist.persistence.model.SymbolRepository;
import fr.livar.mtg.mtgdecklist.scryfall.api.ScryfallApiService;
import fr.livar.mtg.mtgdecklist.scryfall.model.symbol.ScryfallSymbol;

@RestController
public class ScryfallSynchronisationController {
	private SymbolRepository symbolRepository;
	
	@Autowired
	private ScryfallApiService scryfallApiService;
	
	public ScryfallSynchronisationController(SymbolRepository symbolRepository) {
		this.symbolRepository = symbolRepository;
	}
	
	@GetMapping("/scryfallsynchro/symbols")
	public String synchroniseAllSymbols() {
		List<ScryfallSymbol> scryfallSymbols = scryfallApiService.getAllSymbols();
		List<Symbol> symbols = scryfallSymbols.stream().map(scryfallSymbol -> new Symbol(scryfallSymbol.symbol, scryfallSymbol.svgUri, scryfallSymbol.english))
			.collect(Collectors.toList());
		
		symbolRepository.saveAllAndFlush(symbols);
		
		return "" + symbols.size() + " symbols synchronised";
	}
	
}
