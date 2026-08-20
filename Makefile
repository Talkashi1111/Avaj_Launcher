SRC_DIR	:= src
OUT_DIR	:= out
MAIN	:= avaj.Main
SCENARIO = scenario.txt
SOURCES = $(shell find $(SRC_DIR) -name "*.java")
TEST_DIR:= tests
SIM_FILE := simulation.txt

.PHONY: compile run clean re test

compile:
	javac -d $(OUT_DIR) $(SOURCES)

run: compile
	java -cp $(OUT_DIR) $(MAIN) $(SCENARIO)

clean:
	rm -rf $(OUT_DIR)
	rm -f $(SIM_FILE)
	find . -name "*.class" -type f -delete

re: clean compile

test: compile
		java -cp $(OUT_DIR) $(MAIN) $(TEST_DIR)/$(NAME).txt
