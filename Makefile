SRC_DIR	:= src
OUT_DIR	:= out
MAIN	:= avaj.Main
SCENARIO = scenario.txt
SOURCES = $(shell find $(SRC_DIR) -name "*.java")
TEST_DIR:= tests

.PHONY: compile run clean re test

compile:
	javac -d $(OUT_DIR) $(SOURCES)

run: compile
	java -cp $(OUT_DIR) $(MAIN) $(SCENARIO)

clean:
	rm -rf $(OUT_DIR)

re: clean compile

test: compile
		java -cp $(OUT_DIR) $(MAIN) $(TEST_DIR)/$(NAME).txt
