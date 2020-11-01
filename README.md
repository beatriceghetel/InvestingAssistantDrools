# InvestingAssistantDrools
University Project using Drools and Eclipse to suggest financial placements depending on the investor profile.


-----------------------
### SCOPUL PROIECTULUI

Proiectul are ca scop crearea unui prototip folosind Drools, care sa sprijine
un utilizator pentru a efectua plasamente financiare in functie de profilul investitorului.

Se vor lua in calcul o serie de factori de risc, vor fi aplicate formule pentru calculul gradului 
de indatorare (pentru a stabili expunerea reala pe care investitorul o poate investi) si in
functie de acestea si preferintele utilizatorului vor fi efectuate sugestii de investitii.

----------------------

## Criterii pentru evaluarea investitorului

Criteriile de care vom tine cont pentru analiza profilului investitorului sunt urmatoarele:

* **etapa in cariera**
    * la inceputul carierei (I)
    * activ pe piata muncii de minim 5 ani (A)
    * axat pe afaceri de familie (F)
    * administreaza afaceri personale (P)
    * retras din activitate sau pensionat (R)
    
* **categoria de venituri**
    * venit fix lunar (salariu / pensie) (F)
    * salariu pe baza de performanta (V)
    * altele / drepturi de autor (A)
      
* **averea personala**
    * pana in 50k RON
    * intre 50k si 150k RON
    * intre 150k si 300k RON
    * peste 300k RON

* **venituri medii pe ultimele 4 luni**

* **datorii lunare de plata**

* **experienta in tranzactionare**

    
## Criterii pentru evaluarea plasamentelor financiare

Tipurile de produse sugerate

* tipul de investitie
    * imobiliare (grad de risc mediu)
    * tranzactionare (grad de risc ridicat)
    * depozite la vedere (risc minim)
    * depozite la termen (risc scazut)


## Calculul expunerii

Expunere lunara:
`averea_personala
    - 6 * (venitul_mediu - datorii_lunare  - 250) 
    +  > 0.04 * averea_personala`
    
**250 RON** reprezinta suma minima calculata de institutiile bancare pentru **cheltuieli
minime de subzistenta (alimente)**. In categoria datorii_lunare, investitorul ar trebui sa includa
rate lunare (pentru credite imobiliare sau de alt tip), media facturilor etc.

**6** reprezinta un numar minim de luni pentru care se doreste stabilitate financiara, indiferent de investitii.


## Reguli pentru recomandari

1. O **expunere lunara mai mica decat 40%** prezinta un risc ridicat pentru investitii.
Se vor recomanda **investitii din categoria celor cu risc minim sau scazut** (depozite), astfel:
    1. pentru **venituri lunare fixe (F)** si averea personala:
        1. **pana in 50k RON**:
            1. cu experienta in tranzactionare: 40% produse cu risc minim si 40% risc scazut si 20% tranzactionare
            2. fara experienta in tranzactionare: 40% produse cu risc minim si 60% risc scazut
        2. **intre 50k si 150k RON**: 
            1. cu experienta in tranzactionare: 20% produse cu risc minim, 40% produse cu risc scazut si 40% tranzactionare
            2. fara experienta in tranzactionare: 20% produse cu risc minim, 40% produse cu risc scazut si 40% imobiliare
        3. **intre 150k si 300k RON**
            1. cu experienta in tranzactionare: 10% produse cu risc minim, 30% produse cu risc scazut si 60% tranzactionare
            2. fara experienta in tranzactionare: 10% produse cu risc minim, 30% produse cu risc scazut si 60% imobiliare
        4. **peste 300k RON**
            1. cu experienta in tranzactionare: 20% produse cu risc minim, 50% tranzactionare si 30% imobiliare
            2. fara experienta in tranzactionare: 10% produse cu risc minim, 30% produse cu risc scazut si 60% imobiliare
    2. in cazul categoriilor de venit variabile si averea personala:
        1. pana in 150k: 
            1. cu experienta in tranzactionare: 30% produse cu risc minim, 40% risc scazut si 30% tranzactionare
            2. fara experienta in tranzactionare: 30% produse cu risc minim, 40% produse cu risc scazut si 30% risc mediu
        2. peste 150k: 
            1. cu experienta in tranzactionare: 20% produse cu risc minim, 20% produse cu risc scazut, 20% risc mediu si 40% tranzactionare
            2. fara experienta in tranzactionare: 20% produse cu risc minim, 20% produse cu risc scazut si 60% risc mediu

2. Pentru o **expunere lunara > 40%** dar o avere personala pana in 50k RON vom recomanda produse in functie de etapa profesionala:
    1. (I): 20% din avere investita in produse cu risc minim, 40% din avere investita in produse cu risc scazut si 40% risc ridicat
    2. (A), (R): 60% din avere investita in produse cu risc scazut si 40% risc ridicat
    3. (F): 50% produse cu risc scazut si 50% risc ridicat
    4. (P): in cazul celor care detin afaceri personale, vom tine cont de experienta in tranzactionare:
        1. cu experienta in tranzationare: 75% produse cu risc ridicat si 25% risc scazut
        2. fara experienta in tranzactionare: 60% produse cu risc ridicat si 40% risc scazut

3. **Regula speciala in functie de data**: in **lunile noiembrie, martie si iulie** pentru toate recomandarile, 
**se va adauga o marja suplimentara de 10% in depozite la vedere**,
deoarece in aceste perioade ale anului de obicei urmeaza evenimente speciale care necesita o suma suplimentara de bani,
de obicei neprevazuta anticipat de catre investitor (dupa noiembrie urmeaza "luna cadourilor", in martie de obicei
sunt sarbatorile Pascale, in in lunile iulie-august de obicei sunt organizate vacante).


## Entitati

#### Investitor
Contine date despre profilul investitorului, in principal criteriile folosite pentru recomandarea produselor financiare.

#### Plasament
Se refera la produsele financiare ce vor fi recomandate pentru plasamente financiare catre investitori.

#### Recomandare
Recomandarea contine informatii despre data la care a fost efectuata recomandarea, investitorul pentru care
a fost efectuata si lista de produse recomandate.

#### Plasament Recomandat
Contine o referinta catre produs, recomandare, procentul investit si profitul aferent.
