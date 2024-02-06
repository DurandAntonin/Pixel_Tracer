<img src="../Images/logoUvsq.jpg" width="500">

_Durand Antonin_ <br>
_Jougla Maxime_ <br>
_Parciany Benjamin_ <br>
_Zehren William_

<h1 style="color:#5d79e7; text-align: center"> Dossier de conception : Pixel Tracer </h1>

<h1 style="color:#5d79e7; text-align: center; margin-top: 100px"> Table des matières</h1>

<ol>
    <li> <a href="#introduction"> Introduction  </a> </li>
    <li> <a href="#con_pt"> Conception de Pixel Tracer </a> </li>
    <ol>
        <li> <a href="#concepArchi"> Conception architecturale </a> </li>
        <ol>
            <li> <a href="#diagPackages"> Diagramme de packages </a> </li>
            <li> <a href="#diagComposants"> Diagramme de composants </a> </li>
        </ol>
        <li> <a href="#concepDeta"> Conception détaillée </a> </li>
        <ol>
            <li> <a href="#diagClasses"> Diagramme de classes </a> </li>
        </ol>
    </ol>
</ol>



<h2 style="color:#5d79e7; page-break-before: always" id=introduction> Introduction </h2>

Ce document est un dossier de conception divisé en plusieurs parties. Il sera constitué de la conception architecturale et détaillée de Pixel Tracer. Il aura pour but de donner de renseigner toutes les informations sur la conception de l'application ainsi que des diagrammes permettant de la représenter graphiquement.

Pixel tracer est une application sur Linux et sur Windows, qui permet de réaliser des dessins vectoriels en ligne de commande sans interface graphique.

<h2 style="color:#5d79e7" id=con_pt> Conception de Pixel Tracer </h2>

Ce dossier de conception plus léger ne servira qu'a présenter les différents diagrammes représentatifs de la structure de l'application Pixel Tracer.

<h3 style="color:#5d79e7" id=concepArchi> Conception architecturale </h3>

Les diagrammes présentés dans cette section seront les suivants : 

- **Diagramme de packages** 
- **Diagramme de composants**

<h4 style="color:#5d79e7" id=diagPackages> Diagramme de packages </h4>

Un **diagramme de package** permet de représenter l'organisation et la structure d'une application, en modélisant les éléments qui la composent à travers des packages. 

Un package représente un regroupement d'éléments de l'application, il contient donc potentiellement des éléments de l'application de différents types et peut éventuellement contenir d'autres packages pour modéliser une hiérarchie entre ces derniers. 

Des relations de dépendances sont en général utilisées pour représenter les relations qu'ont un ou plusieurs packages entre eux. 

L'objectif premier d'un diagramme de packages est de représenter de manière simple et lisible les différentes fonctionnalités d'une application en regroupant les fichiers en fonctionnalités. 

<div style="text-align:center">
<img src="../Images/diagrammePackages.PNG" width="700px">
<p> Diagramme de package de Pixel Tracer </p>
</div>

Le diagramme de packages de Pixel Tracer contient plusieurs packages principaux :  

- Readline 
- List
- LIBC
- Pixel Tracer (Shape, Draw, Command, Display, ID héritent du package Pixel Tracer)

<h4 style="color:#5d79e7" id=diagComposants> Diagramme de composants </h4>

<h3 style="color:#5d79e7" id=concepDeta> Conception détaillée </h3>

<h4 style="color:#5d79e7" id=diagClasses> Diagramme de classes </h4>




