Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, december 2020

Part of the course **"Parsers which Compute"**

# 4h PRACTISE: small but tricky parsers

  *Small but tricky parsers that illustrate the most common problems.*

## Part 1 - Installation (30min)

### Clonne this git repository

> git clone https://gricad-gitlab.univ-grenoble-alpes.fr/michael_perin/pwc.git

### Import files in Eclipse

Close Eclipse and relauch it with **Workspace=** *the directory of your git clone* `pwc/`

### Install the JavaCC plugin for Eclipse

  1. Lauch Eclipse
  2. Eclipse: Preferences -> General -> Install/update -> Available software sites

      - add `http://eclipse-javacc.sourceforge.net/`

  3. Eclipse: Help -> Install new software -> work with : select JavaCC

      - check [x] JavaCC Eclipse Plug-in
      - [finish]

  4. Restart Eclipse with the appropriate workspace
  5. Eclipse: Window -> show view -> Package Explorer
  6. Package Explorer: `src/` -> buildPath -> Configure Build Path -> JavaCC options -> javacc options : desactivate STATIC [Apply and Close]

* In case of trouble
  - [Installation guide](http://eclipse-javacc.sourceforge.net)
  - [JavaCC official website](https://javacc.org)


## Part 2 - [Practise](src/) (1h + 2h)
