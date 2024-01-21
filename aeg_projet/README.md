```
Michaël PÉRIN,
VERIMAG / Univ. Grenoble-Alpes / INP / Polytech Grenoble,
```

# A long term project with 3rd year students at Polytech Grenoble Engineering school

Part of the course __"Parsers which Compute"__

## [Project 2022](sujet/2022/) - REGEXP to AEF: Parsing REGEXP + Thompson constructions

- A syntax for regular expression
- A parser
- Thompson constructions of the finite automaton

+ Bonus: optimized Thompson constructions to avoid introducting epsilon-transitions

## [Project 2021](sujet/2021/) - GRM to AEF

- A syntax for describing Regular Grammar as `.grm`file
- A parser (in JavaCC) which converts `.grm` to several automata format (`.aef`, `.dot`, transition table in `.html`)
+ Bonus: A java engine for Deterministic Finite Automata (DFA)
+ Bonus: Two extensions of the GRM syntax

## [Project 2020](sujet/2020/) - AEF to DOT

- A [syntax](syntax/AEF_SYNTAX.md) for describing Finite Automata as `.aef` file
- A [parser](JavaProject/src/info3/aef/) (in JavaCC) which converts `.aef` to `.dot` format for visualization with graphwiz
- detection of sink states and unreachable states.


# Future Projects

## Project ? - Control Flow Graph of simple imperatif program

## Project ? - Extension of REGEXP + NFA engine

- Several extensions of the Regular Grammar syntax, eg., ranges `0..9 a..z A..Z`
- A Java engine for Non deterministic Finite Automata (NFA)

+ Bonus: Generation of the execution tree of the NFA

## Project ? - Extension to the full set of operators on Automata, including negation

- Extension of the GRM syntax with intersection and negation
- Algorithm on automata: Prodcut, Determinisation and complementary automaton

+ Bonus: optimized version of negation on set of symbols (avoiding complementary)

## Project ? - Java actions into the grammar
