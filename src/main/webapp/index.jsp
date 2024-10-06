<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/Style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <title>Crédit Bancaire</title>
</head>
<body class="bg">
<div>
    <div class="margin-x">
        <h1 class="titre-center m-t-lg">Demander mon crédit en ligne</h1>
        <a class="d-flex gap-5 w-fit m-y-1" href="">
            <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8"/>
            </svg>
            <p class="p-4">Retour</p>
        </a>
        <div class="flex">
            <div class="card w-75 m-b-6">
                <div class="d-flex justify-b m-b-5">
                    <div class="w-30 flexe">
                        <div class="seconde w-100 titre-center color-four p-y-5">
                            <p class="number">1</p>
                            <p class="p-1">Simuler mon crédit</p>
                        </div>
                        <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="#FDDF35" class="bi bi-caret-down-fill m-t-0" viewBox="0 0 16 16">
                            <path d="M7.247 11.14 2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z"/>
                        </svg>
                    </div>
                    <div class="w-30 third titre-center p-y-5 white">
                        <p class="number">2</p>
                        <p class="p-1">Mes coordonnées</p>
                    </div>
                    <div class="w-30 third titre-center p-y-5 white">
                        <p class="number">3</p>
                        <p class="p-1">Mes infos personnelles</p>
                    </div>
                </div>
                <form action="${pageContext.request.contextPath}/FirstStep" method="post">
                    <div class="margin-x-1">
                        <p class="label" >Mon projet</p>
                        <select class="minimal m-t-1"name="type">
                            <option>J'ai besoin d'argent</option>
                            <option>No external background image</option>
                            <option>No wrapper</option>
                        </select>
                        <p class="label m-t-5" >Je suis</p>
                        <select class="minimal m-t-1" name="position">
                            <option>J'ai besoin d'argent</option>
                            <option>No external background image</option>
                            <option>No wrapper</option>
                        </select>
                        <div class="slider-container">
                            <p class="label m-t-5" name="amount">Montant (en DH)</p>
                            <input class="input1 w-8" type="number" id="sliderValue" max="600000" min="5000" step="1000" value="5000"name="amount">
                            <input type="range" min="5000" max="600000" step="1000" value="5000" class="slider" id="mySlider">
                            <p class="label m-t-5">Durée (en mois)</p>
                            <input class="input1 w-5" name="durationsInMonths" type="number" id="durationValue" min="12" max="120" step="6" value="12">
                            <input type="range" min="12" max="120" step="6" value="12" class="slider" id="durationSlider">
                            <p class="label m-t-5" >Mensualités (en DH)</p>
                            <input class="input1 w-9" name="monthlyPayment" type="number" id="monthlyPayment" min="1" max="80000" value="70">
                            <input type="range" min="1" max="80000"  step="100" value="70" class="slider" id="mensualiteSlider">
                        </div>
                        <div class="flex-center">

                                <button  type="submit" class="button1 m-t-5">
                                    <p class="p-10">Continuer</p>
                                    <p class="p-2">Sans engagement</p>
                                </button>
                        </div>
                    </div>
                </form>
                <div class="m-t-10">
                    <p class="color-four fs-1">Simulation à titre indicatif et non contractuelle. La mensualité minimale est de 180 dirhams.
                        Un client Wafasalaf peut bénéficier d'une tarification plus avantageuse en fonction de ses
                        conditions préférentielles.</p>
                    <p class="color-four fs-1 m-t-4">Conformément à la loi 09-08, vous disposez d’un droit d’accès, de rectification et d’opposition
                        au traitement de vos données personnelles. Ce traitement est autorisé par la CNDP sous le numéro
                        A-GC-206/2014.</p>
                </div>
            </div>
            <div class="card w-20">
                <p class="titre-center mon color-four">Mon récapitulatif</p>
                <p class="color-four bg1">Mon projet</p>
                <p class="color-first pret m-b-9">Prêt Personnel</p>
            </div>
        </div>
    </div>
</div>
<!--<script src="assets/js/Js.js"></script>-->
</body>
</html>
