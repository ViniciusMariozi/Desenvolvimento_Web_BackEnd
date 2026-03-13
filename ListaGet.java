package com.aulaback.aula;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listaget")
public class ListaGet {

    @GetMapping("/soma/{n1}/{n2}")
    public Double soma(@PathVariable double n1, @PathVariable double n2){
    return n1 + n2;
    }

    @GetMapping("/subtracao")
    public Double subtracao(@RequestParam double n1, @RequestParam double n2){
    return (n1 - n2);
    }

    @GetMapping("/multiplicacao/{n1}/{n2}")
    public Double multiplicacao(@PathVariable double n1, @PathVariable double n2){
        return n1 * n2;
    }

    @GetMapping("/divisao")
    public String divisao(@RequestParam double n1, @RequestParam double n2){
        if (n2 == 0){
            return "Impossivel dividir por zero";
        }else{
            return Double.toString(n1/n2);
        }
    }

    @GetMapping("/potenciacao/{n1}")
    public Double potenciacao(@PathVariable double n1){
        return n1 * n1;
    }

    @GetMapping("/temperatura/{c}")
    public double temperatura(@PathVariable double c){
        return (c * 1.8) + 32;
    }

    @GetMapping("/imc")
    public String imc(@RequestParam double peso, @RequestParam double altura){
        double imc = peso / ((altura/100) * (altura/100));
        String classificacao;
        if (imc < 18.5){
            classificacao = "Abaixo do peso";
        }else if(imc >= 18.5 && imc < 25){
            classificacao = "Peso Normal / Saudável";
        } else if (imc >= 25 && imc < 30) {
            classificacao = "Sobrepeso";
        } else if (imc >= 30 && imc < 35) {
            classificacao = "Obesidade Grau I";
        } else if (imc >= 35 && imc < 40) {
            classificacao = "Obesidade Grau II";
        }else {
            classificacao = "Obesidade Grau III";
        }
        return "IMC = " + imc + " Classificação: " + classificacao;
    }

    @GetMapping("/numero/{num}")
    public String numero(@PathVariable double num){
        return "Antecessor = " + Double.toString(num - 1) + " Numero = " + Double.toString(num) + " Sucessor = " + Double.toString(num + 1);
    }

    @GetMapping("/desconto")
    public String desconto(@RequestParam double valor, @RequestParam double desconto){
        return "Valor com desconto = " + Double.toString( valor - (valor * desconto / 100));
    }

    @GetMapping("/tabuada/{num}")
    public String tabuada(@PathVariable int num){
        String resultado = "";
        for(int i = 1; i <= 10; i++){
            resultado += num + " x " + i + " = " +(num * i) + "<br>";
        }
        return resultado;
    }
}
