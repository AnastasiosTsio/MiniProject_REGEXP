Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, december 2020

Part of the course **"Parsers which Compute"**

# 2h practise: Recognizing natural, integer and real numbers

## In the `number_package`

* open the Java Interface `Number.java`

* complete the Java class `Inum.java` and `Rnum.java` implementing `Number`


### A Parser of numbers

We consider the grammar

```haskell
Digit ::= "0" | ... | "9"

Nat ::= Digit . Some_Digits

Some_Digits ::=
  | Digit . Some_Digits
  | ""

Integer ::=
  | Nat
  | "-" Nat

Number ::=
  | Integer Opt_Decimal_Part
  | "." Decimals

Opt_Decimal_Part ::=
  | "." Decimals
  | ""

Decimals ::=
  | Digit . Opt_Decimals

Opt_Decimals ::=
  | Decimals
  | ""
```

### Parser of integers numbers

* open the file `number_parser.jj`

  - complete the parser of natural numbers and integers with computations.
  - keep the rest of the parser in comments.

* *[TEST]* add some tests in the `test()` functions of `number_parser.jj`

* *[RUN]* your parser in a terminal, using `java -cp ./bin number_package.Number_parser`


### Parser of real numbers

* open the file `number_parser.jj` and complete the parser of real numbers with computations.

* *[TEST]* add some tests in the `test()` functions of `number_parser.jj`

* *[RUN]* your parser in a terminal, using `java -cp ./bin number_package.Number_parser`
