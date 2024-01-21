```
Michaël PÉRIN,
VERIMAG / Univ. Grenoble-Alpes / INP / Polytech Grenoble,
December 2022
```

# __6 hours project__
Part of the course __"Parsers which Compute"__

Previous students successfully produced a parser of AEF descriptions with a DOT output for the
graph visualizer, [graphviz](https://graphviz.org) which produces graphical representations
from a text description of nodes and edges in the DOT format.

This year we go one step further.

## Project 2022 - Regular Expression & Thompson constructions

## Goal

The project consists in
1. parsing Regular Expression
2. exporting the result in REG format
3. generating the corresponding automaton using Thompson method and exporting the automaton in DOT

## Illustration

The regular expression in REG format
```JAVA
Regexp(RE){
  a|b
}
```
corresponds to the automaton
```JAVA
AEF(RE){ -> 1 ;
  1 -a-> (2) ;
  1 -b-> (2) ;
}
```
in AEF notation.


## Project 2022

The goal of the project 2022 is to develop several components:

1. a parser of _regular expressions_ in the REG syntax

2. a printer of _regular expressions_ in the REG syntax (for checking the parser)

2. a generator of equivalent automata using Thompson method

3. a export of automaton in the DOT format with special color for hole states and unrechable states

4. an optimized version of Thompson constrution to avoid introducing avoidable &epislon;-transitions


## How far can you go?

>You can choose the level of your project. Each level adds new requirements on top of the lower levels. The evaluation takes into account the realized features and the quality of your code.

### 10/20 : A correct duo parser-printer for standard regular expressions

* a parser of regular expressions in REG syntax
* a exporter of your internal representation which reprints the parsed expression in REG syntax
  with additional parenthesis to eliminate any ambiguity. For instance, `a|b.c` is reprinted as `a|(b.c)`  

These two steps ensure the correctness of your parser : check that your parser/printer reproduces exactly what it parsed.

You will have to modify:
* `info3/regexp/Regexp_parser.jj`
* `info3/regexp/*.java`

##### standard regular expressions

- `$, {}`
- `a, b, ..., z,`
- `(a), ($), ({})`
- `$*, {}*, a*, (a*)*`
- `a.b.c, a|b|c`
- `a.b | c.d`  which is equivalent to `(a.b) | (c.d)` since the concatenation `.` has a higher priority than choice `|`.
- `(a|b).(c|d|$)`
- `((a*|b*)*.(c.d|$))*`

### 11/20 : first extension of regular expressions

Same requirements with extension of the regular expression with two postfix operators `+`, `?`

- `$?, $+`
- `{}+, {}?`
- `a+, a?`
- `a?*, a+*, a**, a+?, a*+?,` ...

### 12/20 : second extension of regular expressions

Same requirements with extension of the regular expression with operator `-` which is used
* as an prefix operator
    - `-$, --$, ---$,` ...
    - `-{}, --{}, ---{},` ...
    - `-a, --a, ---a,` ...
    - `-a*` which is interpreted as `(-a)*`
    - `-(a*)`
* as an infix operator
    - `a|b-b` which is interpreted as `(a|b) - b`
    - `a*-a`  which is interpreted as `(a*) - b`

### 15/20 : Construction of the corresponding automaton using Thompson method

:warning: The construction of the automaton is **not required** for the *minus operator* `-` since it would need
elimination of &epsilon;-transitions and determinisation in order to compute the complement.

You will have to modify `JavaProject/src/info3/aef/Aef.java`

### 16/20 : Exporting in DOT format with colored holes and unreachable states

The export of AEF to DOT already exists. You have to compute hole and unreachable states.

### 20/20 : Optimization of Thompson constructions

Try to do your best without spending all your time on this task.


# Where to start?

> Read this file twice. Have a look at the provided code for the first level. Have a meeting with your team to brainstorm and browse the code. And then, take the tasks in the following order.

* **The grammar of the REG syntax**

The grammar of the REG syntax is not provided.
It is part of the project to create a grammar from the provided examples.

* **The parser**

The parser must build an internal Java representation of a Regexp (see the `regexp` package)
from an `.reg` file.

* **Exporting**

The `export` package contains several static classes which provides the needed functions
for exporting to `REG` and `DOT`.

* **Testing**

The [demo/examples/reg/](../../JavaProject/demo/examples/reg/) directory contains many REG files to test your parser/printer.
It contains a `Makefile` for generating the output of your tools.

* [demo/output/reg/](../../JavaProject/demo/output/reg/) is the directory that receives all files produced by your parser/printer.
  It contains **the expected results**.

## Contents

* [demo/examples/reg/](../../JavaProject/demo/examples/reg/) contains regular expressions in REG syntax for testing

* [REG_SYNTAX.md](../../syntax/REG_SYNTAX.md) **must be completed** with your grammar, followin the example of [AEF_SYNTAX.md](../../syntax/AEF_SYNTAX.md).

* [src/export/](../../JavaProject/src/export/) contains a file for each exporting format REG, GRM, AEF, DOT, HTML. Each file defines basic elements of the format.
You are concerned by `REG.java`.

* [src/info3/regexp](../../JavaProject/src/info3/regexp/) contains the Java packages and a draft of the REG parser
- `regexp_parser.jj` **must be completed**. It contains a draft of the REG parser. It runs wihout error on `re00.reg` and `re01.reg` files.
- The `.java` files **must be completed** and **be compliant with the interface**. They define the basic structures for the internal representation and exporting of a regexp.

* [src/info3/aef/](../../JavaProject/src/info3/aef/) contains the solution to the projet 2020, with a full parser example. It runs without error on all examples
of [demo/examples/aef/](../../JavaProject/demo/examples/aef/) and can be tested using the `Makefile` which generates the `.dot` output of each `.aef` examples.
It can then be transformed into a JPG image using graphviz with command line `dot -Tjpg RE_opt.dot > RE_opt.jpg`. All this is done in the provided `Makefile`.


## Import the project in Eclipse

1. Close Eclipse and relauch it with **workspace =** *the directory of your git clone*

2. Eclipse: File -> Import from source **Project name=**  *JavaProject*


## Usage

The projet is provided as a prototype able to deal with the grammar `RE00.reg` below

```Java
Regexp(R00){
  {}
}
```

You can run the demo using the command in the `demo/examples/reg/` directory
> java -cp ./bin info3.regexp.RegexpParser -opath output/ -ipath . RE00

A `Makefile` is provided in the `demo/examples/reg/` directory
