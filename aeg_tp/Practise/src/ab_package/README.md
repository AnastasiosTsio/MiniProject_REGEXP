Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, december 2020

Part of the course **"Parsers which Compute"**

# 1h practise: Recognizing languages on the {a,b} alphabet

## In the `ab_package/`

### Parser of the language {a^n.b^n | n in Nat}

We consider the grammar

```haskell
P ::= S . "EOF"
S ::=
    | a . S . b
    | ""
```
* open the file `anbn_parser.jj` and complete the parser with computations

* open the file `Couple.java` and complete the methods

* open the file `Main.java` and uncomment parser 1

* *[TEST]* your parser in a terminal, using `java -cp ./bin ab_package.Main`

* *[TRY]* the user-friendly version


### Parser of the language { w in {a,b}* | #a(w) <= #b(w) }

We consider the *user-friendly* grammar below which accepts any words on {a,b}.

```haskell
P ::= S . "EOF"
S ::=
    | a . S
    | b . S
    | ""
```

* open the file `any_ab_parser.jj` and complete the parser with computations

* open the file `Main.java` and uncomment parser 2

* *[TEST]* your parser in a terminal, using `java -cp ./bin ab_package.Main`

## [Next](Practise/src/number_package/)
