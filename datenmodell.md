# Eisverkaufssystem – Datenmodell

## Entitäten

### Eis
- id (PK)
- sorte
- preis

---

### Standort
- id (PK)
- name
- typ (LADEN | LAGER)
- kapazitaet
- groesse (NULL möglich, nur für Lager relevant)

---

### Bestand
- id (PK)
- eis_id (FK -> Eis.id)
- standort_id (FK -> Standort.id)
- menge

---

### Lieferant
- id (PK)
- name

---

### Lieferung
- id (PK)
- lieferant_id (FK -> Lieferant.id)
- lieferdatum
- status

---

### Lieferposition
- id (PK)
- lieferung_id (FK -> Lieferung.id)
- eis_id (FK -> Eis.id)
- standort_id (FK -> Standort.id)
- menge

---

### Bestellung
- id (PK)
- standort_id (FK -> Standort.id)  
  (nur für Standorte vom Typ LADEN)
- datum
- bestellpreis
- status

---

### Bestellposition
- id (PK)
- bestellung_id (FK -> Bestellung.id)
- eis_id (FK -> Eis.id)
- menge
- einzelpreis

---

### Verkauf
- id (PK)
- standort_id (FK -> Standort.id)  
  (nur für Standorte vom Typ LADEN)
- rechnung_id (FK -> Rechnung.id)
- datum

---

### Verkaufsposition
- id (PK)
- verkauf_id (FK -> Verkauf.id)
- eis_id (FK -> Eis.id)
- menge
- einzelpreis

---

### Rechnung
- id (PK)
- datum
- gesamtpreis

---

## Beziehungen

- Standort 1 --- n Bestand
- Eis 1 --- n Bestand

- Lieferant 1 --- n Lieferung
- Lieferung 1 --- n Lieferposition
- Eis 1 --- n Lieferposition
- Standort 1 --- n Lieferposition

- Standort 1 --- n Bestellung
- Bestellung 1 --- n Bestellposition
- Eis 1 --- n Bestellposition

- Standort 1 --- n Verkauf
- Verkauf 1 --- n Verkaufsposition
- Eis 1 --- n Verkaufsposition

- Rechnung 1 --- 1 Verkauf

---

## Fachliche Regeln

### Standort-Typen
- typ = LADEN → Verkauf und Bestellung erlaubt
- typ = LAGER → primär für Lagerhaltung und Lieferung

---

### Validierungsregeln (konzeptionell)

- groesse darf nur für LAGER gesetzt sein
- Verkauf und Bestellung nur für Standorte vom Typ LADEN
- Bestand ist immer genau einem Standort zugeordnet

---