ClASS_PATH = ../../../bin
PARSER = info3.regexp.RegexpParser
EXT = reg

INPUT = .
OUTPUT = ../../output/$(EXT)
SRC_FILES = $(patsubst $(INPUT)/%, %, $(wildcard $(INPUT)/*.$(EXT)))

DOT_FILES = $(wildcard $(OUTPUT)/*.dot)

default:
/snap/eclipse/64/plugins/org.eclipse.justj.openjdk.hotspot.jre.full.linux.x86_64_17.0.4.v20220903-1038/jre/bin/java -Dfile.encoding=UTF-8 -p /home/noah/Documents/A&G Parser/g12/aeg_projet/JavaProject/bin -XX:+ShowCodeDetailsInExceptionMessages -m JavaProject/info3.regexp.RegexpParser -opath demo/output/reg/ -ipath demo/examples/reg/ re32

format: $(SRC_FILES:%.reg=%.format)

dot: $(SRC_FILES:%.reg=%.dot)

jpg: $(DOT_FILES:%.dot=%.jpg)

%.format: %.reg
	@echo ""
	@echo "Resultat attendu :"
	@cat $*.reg
	@echo "PARSING " $< " REPRETING " $*.reg " USING THE COMMAND LINE"
	java -cp $(ClASS_PATH) $(PARSER) -opath $(OUTPUT)/ -ipath $(INPUT)/ -reformat $(basename $<)

%.dot: %.reg
	@echo ""
	@echo "CONVERTING " $< " TO " $*.dot " USING THE COMMAND LINE"
	java -cp $(ClASS_PATH) $(PARSER) -opath $(OUTPUT)/ -ipath $(INPUT)/ -aut $(basename $<)

%.jpg: %.dot
	@echo ""
	@echo "CONVERTING " $< " TO " $@ " USING THE COMMAND LINE"
	dot -Tjpg $< > $@

clean:
	@make cleandot
	@make cleanreg
	@make cleanjpg

cleandot:
	@rm -f $(OUTPUT)/*.dot

cleanjpg:
	@rm -f $(OUTPUT)/*.jpg

cleanreg:
	@rm -f $(OUTPUT)/*.reg
