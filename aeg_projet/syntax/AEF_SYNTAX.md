Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, december 2020

Part of the course **"Parsers which Compute"**

# The grammar of the AEF syntax

## Arrows

* __initial state:__ `->1`
* __epsilon-transition:__ `1 --> 2`
* __single symbol:__ `1-a->2`
* __multiple symbols:__ `1-a,b->2`
* __loop:__
  - `1<a,b` is a shortcut for `1-a,b->1`
  - `1<-a,b->2` is a shortcut for `1-a,b->2-a,b->1`
  - `->1<a <-b,c-> (2)<d` is as shortcut for `->1 ; 1-a->1 ; 1-b,c->(2) ; (2)-b,c->1 ; (2)-d->(2)`

``` Java
AEF ::=
  | "AEF" . "(" . Ident . ")" . "{" . Path_Plus . "}" . EOF

Path_Plus ::=
  | Path . More_Paths

More_Paths ::=
  | ";" . Path_plus
  | ""

Path ::=
  | Possibly_Initial_State . Step_star

Possibly_Initial_State ::=
  | "->" . AEF_State
  | AEF_State

Step_star ::=
  | Step . Step_star  
  | ""

Step ::=
  | Arrow . AEF_State

AEF_State ::=
  | Structured_State . Opt_Loop

Opt_Loop ::=  
  | "<" . Symbols_Star
  | ""

Arrow ::=
  | "<-" . Symbol_Star . Left_or_Double_Arrow_end
  |  "-" . Symbol_Star . "->"

Left_or_Double_Arrow_end ::=
  | "->"
  | "-"  

Symbols_Star ::=
  | Symbol_Plus
  | ""

Symbol_Plus ::=
  | Symbol . More_Symbols   

More_Symbols ::=  
  | "," Symbol_Plus
  | ""

Symbol ::=
  | Ident
```

## AEF states

* __Non negative integer:__ `0`,`1`,`2`,...
* __Any identifier:__ `w`, `w.a`, `w.a.b`, `w.a.b.a`  
* __Set of states:__ `{1,2,3}`, `{(1,2),(3,4)}`
* __Tuple of states:__ `(1,2,3)`, `({1},{2})` are valid states
* __Primed state:__ `1'`,`2''`,`3'''`
* __Equalities of states:__ `1=2=(1,2)={3,4}` is a valid state
* __Acceptor:__ `(` _any state_ `)` is an accepting state


```Java
Structured_State ::=
  | Simple_State  . More_Equiv_States
  | Set_of_States . More_Equiv_States
  | "(" State . Acceptor_or_Tuple . ")"

Acceptor_or_Tuple ::=
  | "," State . More_States
  | "=" State . More_Equiv_States
  | ""

Equiv_States ::=
  | State . More_Equiv_States

More_Equiv_States ::=
  | "=" . State . More_Equiv_States
  | ""  

State ::=
  | Simple_State
  | Set_of_State
  | Tuple_of_State

Simple_State ::=
  | Int . Primed
  | Ident . Primed

Primed ::=
  | "'" . Primed
  | ""

Set_of_State ::=
  "{" . Some_States . "}"

Tuple_of_States ::=
  "(" . At_Least_Two_States . ")"

At_Least_Two_States ::=   
  | State . "," . State . More_States

Some_States ::=
  | State . More_States
  | ""

More_States ::=
  | "," State . More_States
  | ""
```
