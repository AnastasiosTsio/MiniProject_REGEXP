Part of the course **"Parsers which Compute"**

# The grammar of the REG syntax

```Java
PARSE ::= SEED . \EOF

SEED ::= "REGEXP" . "(" . IDENT . ")" . "{" . REXGEP . "}"

REGEXP ::= BASIC_REGEXP

BASIC_REGEXP ::=
  | "{}"
  | SYMBOL

IDENT ::= (LOWERCASE | UPPERCASE | UNDERSCORE)+

SYMBOL ::= "a" | ... | "z"
```
