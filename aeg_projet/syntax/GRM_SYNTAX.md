
```Java
PARSE ::= GRAMMAR . \EOF

GRAMMAR ::= "Grammar" . "(" . IDENT . ")" . "{" . RULES . "}" . RUNS

RULES ::= ...

RULE ::=  IDENT . "::=" . ("|")? . PRODUCTIONS

PRODUCTIONS ::= ...

PRODUCTION ::= ...

STRING ::= QUOTE . ... . QUOTE

SYMBOL ::= ...

WORD ::= ...

RUNS ::= ...

RUN ::= IDENT . "(" . WORD . ")" . ";"

// extensions (++) et (+++)

EXPR ::=
  | STRING
  | IDENT
  | CHOICE
  | SEQUENCE

CHOICE ::= ...

SEQUENCE ::= EXPR . ( "." EXPR )*
```
