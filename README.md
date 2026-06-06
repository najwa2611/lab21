
# Sensor Lab - Application de Capteurs Android

## Description

Application Android complète permettant d'exploiter tous les capteurs embarqués d'un smartphone. Visualisation des mesures en temps réel, graphes dynamiques, et reconnaissance simple d'activité.

## Palette de Couleurs

| Usage | Couleur | Code |
|-------|---------|------|
| Primaire | Rouge Sang | #5C1010 |
| Fond principal | Noir Pur | #000000 |
| Accent | Crimson Éclatant | #C30101 |
| Texte | Or | #D4AF37 |
| Secondaire | Beige Chaud | #EEDC82 |
| Cards | Bourgogne | #4A0E17 |
| Séparateurs | Rouge Brique | #940000 |

## Fonctionnalités

### 1. Liste des Capteurs
- Affiche tous les capteurs disponibles
- Informations techniques complètes (résolution, puissance, range, etc.)

### 2. Capteurs Environnementaux
- Température ambiante
- Humidité relative
- Proximité
- Champ magnétique

### 3. Capteurs de Mouvement
- Accéléromètre (axes X, Y, Z)
- Gravité
- Gyroscope (rad/s)

### 4. Fonctionnalités Avancées
- Compteur de pas (économique en batterie)
- Boussole numérique (Nord, Est, Sud, Ouest)
- Reconnaissance d'activité (marche, saut, position stable)

## Structure du Projet

```
app/src/main/java/com/example/sensors/
│
├── MainActivity.java
├── fragments/
│   ├── SensorsListFragment.java
│   ├── SensorGraphFragment.java
│   ├── MotionSensorFragment.java
│   ├── StepCounterFragment.java
│   ├── CompassFragment.java
│   └── ActivityRecognitionFragment.java
├── utils/
│   └── SensorFormatter.java
└── views/
    └── LineChartView.java
```

## Installation

1. Cloner le projet
2. Ouvrir avec Android Studio
3. Synchroniser Gradle
4. Exécuter sur un appareil Android (API 24+)

## Permissions Requises

```xml
<uses-permission android:name="android.permission.ACTIVITY_RECOGNITION" />
```

## Utilisation

### Menu Principal
- **Sensors** - Liste complète des capteurs
- **Temperature** - Graphe température
- **Humidite** - Graphe humidité
- **Proximite** - Détection de proximité
- **Magnetic** - Champ magnétique
- **Accelerometre** - Mouvement 3 axes
- **Gravite** - Composante gravitationnelle
- **Gyroscope** - Rotation
- **Compteur de pas** - Pas depuis démarrage
- **Boussole** - Direction cardinale
- **Reconnaissance d'activite** - Classification mouvement

### Tests avec Émulateur

L'émulateur Android supporte les capteurs virtuels :
- Accéléromètre
- Magnétomètre
- Proximité
- Température
- Humidité

## Détails Techniques

### Graphe Personnalisé (LineChartView)
- Affichage temps réel
- Auto-échelle dynamique
- Dernières 80 mesures
- Min/Max affichés

### Filtre Passe-Bas pour Accéléromètre
```java
gravity[0] = ALPHA * gravity[0] + (1 - ALPHA) * x;
linearX = x - gravity[0];
```

### Reconnaissance d'Activité
- **Saut** : Pic > 10 m/s²
- **Marche** : Écart-type > 1.2
- **Stable** : Variation minimale
- **Position** : Analyse orientation

## Build avec Gradle Kotlin DSL

```bash
./gradlew build
./gradlew installDebug
```

## Prérequis

- Android Studio Hedgehog | 2023.1.1+
- JDK 8 ou supérieur
- Android SDK API 24+
- Appareil physique ou émulateur avec capteurs

