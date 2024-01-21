Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, december 2020

Part of the course **"Parsers which Compute"**

# Part 1 - Toy examples on the {a,b} alphabet

The goal is to write two parsers
- `anbn_parser` that recognizes { a^n.b^n | n in Nat }
- `any_ab_parser` that recognizes { w in {a,b}* | #a(w) <= #b(w) }

## The [`ab_package/`](ab_package/) contains
- The Java class `Main.java` shows how to call the parsers  
- The Java class `AsciiFont.java` is used for pretty printing in color into a terminal
- The Java class `Couple.java` implements couple (left,right) **(to be completed)**
- The JavaCC parser `anbn_parser.jj` **(to be completed)**
- The JavaCC parser `any_ab_parser.jj` **(to be completed)**

# Part 2 - Parsing numbers  

The goal is to write a parser that recognizes natural, integer and real numbers.

 - `012`  is recognized as `Inum(12)` of type Number
 - `-12`  is recognized as `Inum(-12)` of type Number
 - `0.12` is recongized as `Rnum(0.12)` of type Number


## The [`number_package/`](number_package/) contains
- The Java Interface `Number.java` and two implementations of the Interface
  - `Inum.java` **(to be completed)**
  - `Rnum.java` **(to be completed)**
- The Java class `OptDouble.java` implements optional double **(to be completed)**
- The JavaCC parser `number_parser.jj` **(to be completed)**
