ClASS_PATH = ../../../bin/
PARSER = info3.aef.AEF_Parser
EXT = aef

INPUT = .
OUTPUT = ../../output/$(EXT)
SRC_FILES = $(patsubst $(INPUT)/%, %, $(wildcard $(INPUT)/*.$(EXT)))

DOT_FILES = $(wildcard $(OUTPUT)/*.dot)

default:
	@less Makefile

# format: $(SRC_FILES:%.aef=%.format)

dot: $(SRC_FILES:%.aef=%.dot)

jpg: $(DOT_FILES:%.dot=%.jpg)

%.format: %.aef
	@echo ""
	@echo "CONVERTING " $< " TO " $*.dot " USING THE COMMAND LINE"
	java -cp $(ClASS_PATH) $(PARSER) -opath $(OUTPUT)/ -ipath $(INPUT)/ -reformat $(basename $<)

%.dot: %.aef
	@echo ""
	@echo "CONVERTING " $< " TO " $*.dot " USING THE COMMAND LINE"
	java -cp $(ClASS_PATH) $(PARSER) -opath $(OUTPUT)/ -ipath $(INPUT)/ -dot $(basename $<)

%.jpg: %.dot
	@echo ""
	@echo "CONVERTING " $< " TO " $@ " USING THE COMMAND LINE"
	dot -Tjpg $< > $@

clean:
	@make cleanaef
	@make cleandot
	@make cleanjpg

cleanaef:
	@rm -f $(OUTPUT)/*.aef

cleandot:
	@rm -f $(OUTPUT)/*.dot

cleanjpg:
	@rm -f $(OUTPUT)/*.jpg
