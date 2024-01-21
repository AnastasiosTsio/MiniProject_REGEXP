```
Michaël PÉRIN,
VERIMAG / Univ. Grenoble-Alpes / INP / Polytech Grenoble,
December 2021
```

# __6 hours project__
Part of the course __"Parsers which Compute"__

The 2020 students successfully produced a parser of AEF descriptions with a DOT output, [G01_DFA.dot](exported/G01_DFA.dot), for the
graph visualizer, [graphviz](https://graphviz.org) which produces graph representations
from a text description of nodes and edges in the DOT format. This year we switch to the next step.

# Project 2021 : GRM to FSA
> Translation of Determinitic Regular Grammars into Running Deterministic Finite State Automata


## Goal

The project consists in the translation of Regular Grammar descriptions into Finite State Automata in three forms:
- graphical representation in the DOT format
- textual representation in AEF
- java representation (as a table of transitions)
for a java engine running the automaton on input string

## Illustration

The regular grammar
```JAVA
Grammar(G01){
  L1 ::= "a" . L2
  L2 ::= "a" . L1
       | "b" . L2
       | ""
}        
```
corresponds to the automaton
```JAVA
AEF(G01_DFA){ -> L1 ;
  L1  -a-> (L2) ;
 (L2) -a->  L1  ;
 (L2) -b-> (L2) ;
}
```
in AEF notation.


> Note that the production `""` in language `L2` of the grammar stands for the void word (epsilon) and generates an accepting state `(L2)` in the automaton.






## Project 2021

The goal of the project 2021 is to develop several components:

1. a parser of _regular grammars_ in the GRM syntax

2. a generator of equivalent automata in AEF / DOT formats (deterministic or non deterministic, depending on the grammar)

3. engines  for running the deterministic finite automata (DFA) on input string

4. several exporters to GRM, DOT, AEF formats


## How far can you go?

>You can choose the level of your project. Each level adds new requirements on top of the lower levels. The evaluation takes into account the realized features and the quality of your code.

### 12/20 : A correct duo parser-printer

* a parser of regular grammars in GRM syntax
* a exporter of your internal grammar representation that reprints the parsed grammar in GRM syntax

synthesized two steps ensure the correctness of your parser, your internal structure and your exporter to GRM syntax.

You will have to modify:
* `grammar/grm_parser.jj`
* `grammar/*.java`
* `export/GRM.java`
* `finite_automata/SharedSymbol.java`

### 14/20 : Finite Automata as List of transitions

* a generator of automata transitions from the AST
* the output of the automaton in AEF format and DOT format

The grammar can be determinitic or non deterministic ; non determinism is not an issue at this level.

You will have to additionnally modify:
* `finite_automata/FSA.java`
* `finite_automata/Aef_printer.java`

### 16/20: Table of transitions for deterministic automata


* construction of the transition table (as a Java array of states) of a Deterministic Finite Automaton for the engine of the next level

* (?) exporting the transition table as a html table

> The transition table of a DFA cannot represent non determinism such as
```Java
L ::= "a" . L1 | "a" . L2
```

> :bulb: __The detection of non determinism__ can easily be done during the construction of the transition table. If the grammar is non deterministic the construction of the DFA simply fails.

You will have to additionnally modify:
* `finite_automata/DFA.java`

### 18/20 : Deterministic Finite Automata Engine

* The DFA engine uses the transition table. It takes a string as input, runs the automaton on the input and tells if the word is accepted or not.

* Extend the parser to accept challenges in the form of sequence of calls placed after the grammar

```Java
Grammar(G01){
  L1 ::= "a" . L2
  L2 ::= "a" . L1
       | "b" . L2
       | ""
}   
L1(abbb);
L2(bbaa);
L2();
```

 - `L1(abbb)` means _does the grammar/automaton accepts the word "abbb" when starting with L1 as initial state ?_

 - `L2(bbaa)` means _does the grammar/automaton accepts the word "bbaa" when starting with L2 as initial state ?_

The engine must run and print the result `L1(abbb) = accept` or `L1(abbb) = reject` for each challenge.

You will have to additionnally modify:
* `finite_automata/DFA.java`


### 19/20 : (++) First Extension of the GRM syntax

* The parser and the generator of transitions must be extended to allow disjunction of symbols, see `G07+.grm`

```Java
Grammar(G07){
  L1 ::= ("a" | "b") . L1
       | "c"
}   
```

You will have to modify:
* `grammar/grm_parser.jj`
* add (at least) a class `grammar/Choice.java`
* :warning: keep a copy of level 18/20 before starting this step on which you could fail due to time running short.

### 20/20 : (+++) Second Extension of the GRM syntax

* The parser and the generator of transitions must be extended to allow sequence of symbols, see `G08+.grm`.

```Java
Grammar(G08){
  L1 ::= "a" . "b" . "c" . L1
       | ""
}   
```

You will have to modify:
* `grammar/grm_parser.jj`
* add (at least) a class `grammar/Sequence.java`
* :warning: keep a copy of level 19/20 before starting this last step on which you could fail ; it is quite tricky.


# Where to start?

> Read this file twice. Have a look at the provided code for the first level. Have a meeting with your team to brainstorm and browse the code. And then, take the tasks in the following order.

* **The grammar of the GRM syntax**

The grammar of the GRM syntax is not provided.
It is part of the project to create a grammar from the provided examples of AEF syntax.

* **The parser**

The parser must build an internal Java representation of a Grammar (see the `grammar` package)
from an `.grm` file.

* **Exporting**

The `export` package contains several static classes which provides the needed functions
for exporting to `DOT`, `AEF` , `HTML`. The `GRM` static class must be written in the same spirit.

## Contents

* [output/](output/) is the directory that receives all files produced by the projects

* [src/aef/](src/aef/)
  - contains the solution to the projet 2020, with a full parser example.
  - `make demo_aef` at the Project level runs the 2020 project

* [example/grm/](examples/grm/) contains grammars in GRM syntax for testing

* [doc/GRM_SYNTAX.md](GRM_SYNTAX.md) **must be completed** with your grammar for recognizing GRM files.

* [src/](src/) contains Java packages and a draft of the GRM parser

* [src/export/](src/export/) contains a file for each exporting format GRM, AEF, DOT, HTML. Each file defines basic elements of the format.
  - `GRM.java` **must be completed** based on the `AEF.java` example.


* [src/grammar/](src/grammar/)
  - `grm_Parser.jj` **must be completed**. It contains a draft of the GRM parser. It runs wihout error only on  the `G01.grm` file.
  - `Grammar.java`, `Language.java`, `Production.java` **must be completed**. They define the basic structures for the internal representation of a grammar and the exporting of the grammar back into the GRM syntax for checking.


* [src/finite_automata/](src/finite_automata/)
  - `Dot_printer.java` is a full example of printer of nodes, labels, edges in dot format
  - `Aef_printer.java` **must be completed** based on the example of the `Dot_printer`
  - `State.java, Symbol.java, Transition.java, Run.java` define the basic elements for defining automata.
  - `SharedStates.java` is a full example of sharing.
  - `SharedSymbols.java` **must be completed** based on the example of the shared states.
  - `FSA.java` **must be completed**. It contains the main structure for storing transitions of an automaton.
  - `DFA.java` **must be completed** in order to
  translatesthe FSA description into a table of transition, used by the engine for running the automaton on input strings.


## Import the project in Eclipse

Close Eclipse and relauch it with **workspace:** *give the directory of your git clone*

## Usage

The projet is provided as a prototype able to deal with the grammar `G01.grm` below

```Java
Grammar(G01){
  L1 ::= ""
}
```
producing the automaton `G01_FSA.dot` -- the states HOLE and EXIT are useless in this case.

You can run the demo using the command  
> java -cp ./bin grammar.GRM_Parser -opath output/ -ipath examples/grm/ G01
