# Unit Testing in Python

Bei dieser Aufgabe arbeiten Sie mit einem persönlichen Fork. Pull Requests
brauchen Sie jedoch keine zu machen. Halten Sie Ihre Änderungen mit Git fest
(`git add`, `git commit`) und übertragen Sie diese auf den zentralen Git-Server
(`git push`).

Achten Sie auch darauf, dass Sie aussagekräftige Commit Messages verwenden:

- gut: `'Aufgabe 4.1: Divide()-Methode umgesetzt, damit der Testfall durchläuft'`
- gut: `'Exercise 4.1: implemented Divide() method in order to make test case pass'`
- schlecht: `'Aufgabe gelöst'`
- schlecht: `'finished exercise'`

## Aufgabe 1: Setup

Erstellen Sie einen Fork von diesem Repository. Clonen Sie anschliessend ihren
persönlichen Fork, wobei Sie die Angabe `[username]` durch Ihren tatsächlichen
Benutzernamen ersetzen müssen:

    git clone https://code.frickelbude.ch/[username]/unittest-python.git

Öffnen Sie den Ordner `unittest-python` anschliessend mit Visual Studio Code
(oder mit Ihrer präferierten Entwicklungsumgebung). Visual Studio Code sollte
Ihnen automatisch die Installation der
[Python-Erweiterung](https://marketplace.visualstudio.com/items?itemName=ms-python.python)
vorschlagen. Installieren Sie diese, falls Sie nicht schon darüber verfügen.

Öffnen Sie ein Terminal und wechseln Sie ins Verzeichnis `unittest-python`.

    TODO: venv aufsetzen, pytest installieren, usw.

Geben Sie folgenden Befehl ein:

    pytest

Wenn alles geklappt hat, sollte die Ausgabe ungefähr folgendermassen aussehen
(die Zahlen können variieren):

    TODO: Ausgabe

Falls Sie eine ganz andere Ausgabe sehen, stimmt etwas mit Ihrem Setup nicht.
Gehen Sie zurück zum Repository
[python-warmup](https://code.frickelbude.ch/m426/python-warmup#installation) und
setzen Sie Ihre Umgebung nach dieser Anleitung richtig auf.

Bei Unklarheiten oder Problemen fragen Sie die Lehrperson.

## Aufgabe 2: Grundrechenarten Addition und Subtraktion

Öffnen Sie die Dateien `tests/calculator_test.cs` (Testcode) und
`calculator/calculator.py` (Produktivcode). Ordnen Sie die Editoren am besten so
an, dass der Testcode links und der Produktivcode rechts ist. Das gibt Ihnen
einen guten Überblick.

### Aufgabe 2.1: Code lesen

Betrachten Sie den Testcode. Gehen Sie diesen von oben bis unten durch und
versuchen Sie zu verstehen, was auf der jeweiligen Zeile passiert.

Wenn Sie auf eine Stelle stossen, wo vom Testcode aus der Produktivcode
aufgerufen wird, lesen Sie auch den Produktivcode.

### Aufgabe 2.2: Tests ausführen

TODO: instruktionen anpassen? -- hier weiterfahren!

Sie können einzelne Testmethoden ausführen, indem Sie oberhalb davon auf `Run
Test` klicken. Oberhalb der Klasse können Sie auf `Run All Tests` klicken, um
alle Testfälle der jeweiligen Klasse auszuführen.

In Visual Studio Code gibt es unten ein Fenster mit dem Namen `Output`, wo Sie
das Testergebnis sehen können.

Wenn Sie es komfortabler haben wollen, können Sie sich die Erweiterung [.NET Core Test
Explorer](https://marketplace.visualstudio.com/items?itemName=formulahendry.dotnet-test-explorer)
installieren.

### Aufgabe 2.3: Produktivcode manipulieren

Passen Sie nun eine der beiden Methoden `Add` oder `Subtract` an, sodass diese
zwar noch kompiliert werden können, jedoch ein falsches Ergebnis zurückliefern.
Führen Sie die Tests erneut aus. Sehen Sie den Unterschied zu vorher?

Machen Sie Ihre Änderung anschliessen wieder rückgängig, sodass alle Tests
wieder fehlerfrei durchlaufen.

### Aufgabe 2.4: Tests manipulieren

Ändern Sie nun in einer der beiden Methoden `TestAddThreeToTwoIsFive` oder
`TestSubtractFourFromSixIsTwo` die Werte der Variablen `a` oder `b`. Was denken
Sie, was passieren wird?

Führen Sie anschliessend die Tests aus und überprüfen Sie Ihre Vermutung!

Passen Sie nun den Wert der Variablen `expected` entsprechend an, sodass alle
Tests wieder fehlerfrei durchlaufen.

## Aufgabe 3: Multiplikation

Im Folgenden erweitern Sie den `Calculator` um die Grundrechenart Multiplikation.

### Aufgabe 3.1: Test schreiben

Schreiben Sie in `CalculatorTest` einen neuen Testfall für eine Multiplikation
analog zu den beiden bestehenden Testfällen. Halten Sie sich dabei an die
Struktur `Arrange/Act/Assert` oder `Given/When/Then`.

Der Testfall wird nicht durchlaufen, ja kann nicht einmal kompiliert werden.
Warum nicht?

### Aufgabe 3.2: Produktivcode schreiben

Nehmen Sie nun in `Calculator` die notwendigen Erweiterungen vor, damit der
vorher definierte Testfall durchläuft. (Sie brauchen dazu eine neue Methode
namens `Multiply` zu schreiben.)

Führen Sie anschliessend die Tests aus und stellen Sie sicher, dass alles
fehlerfrei durchläuft.

## Aufgabe 4: Division

Im Folgenden erweitern Sie den `Calculator` um die Grundrechenart Multiplikation.

### Aufgabe 4.1: Test und Produktivcode schreiben

Machen Sie das gleiche für die Division wie zuvor für die Multiplikation. Lassen
Sie die Tests zwischen den einzelnen Arbeitsschritten jeweils durchlaufen.

Welchen Datentyp sollte der Rückgabewert sinnvollerweise haben?

### Aufgabe 4.2: Sonderfall (Division durch 0)

Im Gegensatz zur Addition, Subtraktion und Multiplikation gibt es bei der
Division einen Sonderfall: Die Division eines beliebigen Dividenden durch den
Divisor 0 ist nicht definiert!

Definieren Sie einen neuen Testfall, der einen beliebigen Dividenden durch den
Divisor 0 teilt.

In diesem Testfall geht es nicht darum, das Ergebnis der Division zu prüfen.
Stattdessen müssen Sie überprüfen, ob eine Exception geworfen wird. Bei der
Division durch 0 wird eine `DivideByZeroException` geworfen. Überprüfen Sie
folgendermassen, ob dies der Fall ist:

```csharp
Assert.Throws<DivideByZeroException>(() => /* "Act"/"When"-Teil Ihres Codes */);
```

### Aufgabe 4.3: Bessere Handhabung des Sonderfalls

Passen Sie Ihren Testfall nun an, sodass nicht mehr eine
`DivideByZeroException`, sondern eine `ArgumentException` erwartet wird. Nach
dieser Änderung wird Ihr Testfall aber nicht mehr durchlaufen.

Passen Sie nun den Produktivcode so an, dass eine `ArgumentException` geworfen
wird, falls der Divisor 0 beträgt. Ihr Test sollte nun wieder durchlaufen.

## Aufgabe 5: Arithmetisches Mittel berechnen

Öffnen Sie die Dateien `AverageTest.cs` und `Average.cs` und ordnen Sie die
Editoren nebeneinander an, sodass Sie den ganzen Code im Blick haben.

### Aufgabe 5.1: Arithmetisches Mittel von zwei Zahlen

Betrachten Sie die Testmethode `TestMeanOfTwoNumbers` und die dazugehörige
Methode `Mean`. Hiermit wird der Durschnitt (genauer: das arithmetische Mittel)
berechnet.

Passen Sie den Testfall `TestMeanOfTwoNumbers` an, indem Sie zwei andere Zahlen
als `1` und `3` in die Liste setzen, sodass der Test nach dieser Anpassung
scheitert.

Anschliessend passen Sie den Wert von `expected` an, sodass der Test wieder durchläuft.

### Aufgabe 5.2: Arithmetisches Mittel von fünf Zahlen

Schreiben Sie einen neuen Testfall `TestMeanOfFiveNumbers` analog zum Testfall
`TestMeanOfTwoNumbers`, nur dass Sie hier den Durschnitt von fünf Zahlen
berechnen.

### Aufgabe 5.3: Arithmetisches Mittel einer leeren Liste

Schreiben Sie einen neuen Testfall `TestMeanOfNoNumbers`. Dieses mal verwenden
Sie eine leere Liste. Was denken Sie, wird bei der Ausführung des Tests
passieren?

Fangen Sie den Fehler im Produktivcode ab (Methode `Mean`), sodass eine
`ArgumentException` geworfen wird, wenn die Methode mit einer leeren Liste
aufgerufen wird.

## Aufgabe 6: Median berechnen

Das arithmetische Mittel ist immer dann nützlich, wenn es auf Zahlen basiert,
die nicht zu weit auseinanderliegen. Dies ist z.B. bei einem Notendurchschnitt
(Zahlen von 1 bis 6) oder bei Klassengrössen (maximal ca. 25) sinnvoll.

Bei Zahlen, die sehr weit auseinanderliegen, sagt das arithmetische Mittel
leider nicht mehr viel aus. Nehmen Sie als Beispiel das Durchschnittsvermögen
aller Leute in unserem Klassenzimmer. Dies wird wohl deutlich unter einer
Million CHF liegen. Betritt Bill Gates das Klassenzimmer, wären wir "im
Durschnitt" (d.h. mit dem arithmetischen Mittel) plötzlich Milliardäre.

Für solch stark divergierende Zahlenreihen ist darum der _Median_ eine bessere
Statistik. Der Median ist der Wert in der Mitte einer sortierten Zahlenreihe. Er
wird folgendermassen ermittelt:

1. Bei einer Zahlenreihe mit einer _ungeraden_ Anzahl von Elementen ist es das Element in der Mitte.
    - Beispiel: Der Median von `[1, 2, 6, 7, 8]` ist `6`, weil `6` in der Mitte ist.
2. Bei einer Zahlenreihe mit einer _geraden_ Anzahl von Elementen ist es das arithmetische Mittel der beiden mittleren Werte.
    - Beispiel: Der Median von `[1, 2, 5, 6, 7, 8]` ist `(5+6)/2`, weil `5` und `6` in der Mitte liegen.
3. Für eine Zahlenreihe _ohne_ Elemente (leere Zahlenreihe) ist der Median nicht definiert.
    - Beispiel: Der Median von `[]` ist nicht definiert.

### Aufgabe 6.1: Testfälle definieren

Definieren Sie die folgenden drei Testfälle:

1. `TestMedianForOddNumberOfElements`: Der Median einer Zahlenreihe mit ungerader ("odd") Anzahl von Elementen soll der Wert in der Mitte der Zahlenreihe sein.
2. `TestMedianForEvenNumberOfElements`: Der Median einer Zahlenreihe mit gerade ("even") Anzahl von Elementen soll das arithmetische Mittel der beiden Werte in der Mitte der Zahlenreihe sein.
3. `TestMedianForNoElements`: Der Median einer Zahlenreihe ohne Elemente soll nicht berechnet werden, stattdessen soll eine `ArgumentException` geworfen werden.

Führen Sie diese aus und stellen Sie sicher, dass sie "erfolgreich scheitern" (d.h. kompilieren, aber nicht durchlaufen).

### Aufgabe 6.2: Median implementieren

Implementieren Sie nun die Methode `Median`, welche eine Zahlenreihe
entgegennimmt und das gewünschte Ergebnis berechnet. Führen Sie dabei immer
wieder die Tests aus, um zu überprüfen, ob alles wie gewünscht funktioniert.

### Aufgabe 6.3: Testdefinitionen anpassen

Verändern Sie nun die beiden Testfälle `TestMedianForOddNumberOfElements` und
`TestMedianForEvenNumberOfElements`, indem Sie bei der Liste jeweils zwei
weitere Werte hinzufügen. Bringen Sie dadurch den Test zum Scheitern!

Passen Sie anschliessend Ihren Erwartungswert an, sodass die Tests wieder
durchlaufen.

### Aufgabe 6.4: Eingabedaten randomisieren

Verändern Sie die Reihenfolge Ihrer Zahlenreihe mehrmals. Laufen die Tests nach
jeder Änderung immer noch durch?

Wenn ja, ist Ihre Implementierung bereits solide genug.

Wenn nein, müssen Sie Ihre Implementierung noch erweitern (Tipp: Sortierung!).

## Zusatzaufgabe 1: Modus berechnen

Neben Mean und Median gibt es noch den sogenannten _Modus_, welcher das am
häufigsten auftretende Element in einer Reihe bezeichnet.

Beispiele:

1. Der Modus von `[1]` ist `1`.
2. Der Modus von `[1, 1]` ist `1`.
3. Der Modus von `[1, 1, 2]` ist `1`.
4. Der Modus von `[1, 1, 2, 2]` ist `[1, 2]`.
5. Der Modus von `[1, 1, 2, 2, 3]` ist `[1, 2]`.
6. Der Modus von `[1, 1, 2, 2, 3, 3]` ist `[1, 2, 3]`.
7. Der Modus von `[1, 1, 2, 2, 3, 3, 3]` ist `3`.
8. Der Modus von `[1, 1, 2, 2, 3, 3, 3, 3]` ist `3`.

Definieren Sie verschiedene Testfälle und implementieren Sie anschliessend die
`Mode`-Methode. Diese soll in jedem Fall eine Liste von Zahlen zurückgeben, auch
wenn nur ein einzelnes Element das Häufigste ist.

Weitere Informationen zum Modus finden Sie z.B. auf [Wikipedia](https://de.wikipedia.org/wiki/Modus_(Statistik)).

## Zusatzaufgabe 2: Standardabweichung

Die Standardabweichung (Standard Deviation, oft als `sd` abgekürzt) gibt den
durchschnittlichen Abstand der Zahlen in einer Zahlenreihe von deren
Durchschnitt an. Sie wird folgendermassen Berechnet:

    sd = sqrt(((x1 - mean)² + (x2 - mean)² + ... + (xn - mean)²)/n)

Wobei gilt:

- `sd`: zu berechnende Standardabweichung
- `sqrt()`: Wurzelfunktion
- `x1`, `x2`, …, `xn`: Elemente der Zahlenreihe
- `mean`: das arithmetische Mittel der gegebenen Zahlenreihe
- `n`: Anzahl der Elemente der Zahlenreihe (Länge der Liste)

Schreiben Sie zunächst einige Testfälle:

1. Die Standardabweichung einer leeren Zahlenreihe ist nicht definiert (eine `ArgumentException` soll geworfen werden).
2. Die Standardabweichung einer Zahlenreihe bestehend aus einem Wert beträgt `0`.
3. Die Standardabweichung der Zahlenreihe `[1, 3]` beträgt `1`.
4. Die Standardabweichung der Zahlenreihe `[1, 5]` beträgt `2`.
5. Die Standardabweichung der Zahlenreihe `[1, 2, 3, 4, 5]` beträgt ca. `1.414` (`1.41 < sd < 1.42`)
    - Verwenden Sie hierzu `Assert.InRange(sd, 1.41, 1.42)`

Und implementieren Sie anschliessend die Methode `StandardDeviation`, welche die Standardabweichung korrekt berechnen sollte.
