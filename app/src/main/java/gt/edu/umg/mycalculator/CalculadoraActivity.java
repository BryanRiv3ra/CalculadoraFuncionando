package gt.edu.umg.mycalculator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.function.Function;



public class CalculadoraActivity extends AppCompatActivity {
    private EditText txtLimiteInferior;
    private EditText txtLimiteSuperior;
    private EditText txtDivisiones;
    private EditText txtResultado;
    @Override
    protected void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.activity_calculadora);

        Button btnRegresarcalcu = findViewById(R.id.btnRegresarcalcu);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btn0 = findViewById(R.id.btn0);
        Button btnPunto = findViewById(R.id.btnPunto);
        Button btnIgual = findViewById(R.id.btnIgual);
        Button btnX = findViewById(R.id.btnX);
        Button btnY = findViewById(R.id.btnY);
        Button btnElvar = findViewById(R.id.btnElevar);
        Button btnIntegral = findViewById(R.id.btnIntegral);
        Button btnParentesis1 = findViewById(R.id.btnParentesis1);
        Button btnParentesis2 = findViewById(R.id.btnParentesis2);
        Button btnValorAbsoluto = findViewById(R.id.btnValorAbsoluto);
        Button btnEuler = findViewById(R.id.btnEuler);
        Button btnSeno = findViewById(R.id.btnSeno);
        Button btnCoseno = findViewById(R.id.btnCoseno);
        Button btnLogaritmo = findViewById(R.id.btnLogaritmo);
        Button btnPi = findViewById(R.id.btnPi);
        Button btnMulti = findViewById(R.id.btnMulti);
        Button btnSuma = findViewById(R.id.btnSuma);
        Button btnResta = findViewById(R.id.btnResta);
        Button btnDivision = findViewById(R.id.btnDivision);
        Button btnRaiz = findViewById(R.id.btnRaiz);
        Button btnAC = findViewById(R.id.btnAC);
        Button btnBorrar = findViewById(R.id.btnBorrar);
        Button btnInfinito = findViewById(R.id.btnInfinito);
        Button btnFlecha = findViewById(R.id.btnFlecha);
        Button btnDX = findViewById(R.id.btnDx);
        Spinner spinnerIntegrales = findViewById(R.id.spinner_integrales);
        txtLimiteInferior = findViewById(R.id.txtLimiteInferior);
        txtLimiteSuperior = findViewById(R.id.txtLimiteSuperior);
        txtDivisiones = findViewById(R.id.txtDivisiones);
        txtResultado = findViewById(R.id.txtResultado);



        btnRegresarcalcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculadoraActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn1.setOnClickListener(v -> txtDivisiones.append("1"));
        btn2.setOnClickListener(v -> txtDivisiones.append("2"));
        btn3.setOnClickListener(v -> txtDivisiones.append("3"));
        btn4.setOnClickListener(v -> txtDivisiones.append("4"));
        btn5.setOnClickListener(v -> txtDivisiones.append("5"));
        btn6.setOnClickListener(v -> txtDivisiones.append("6"));
        btn7.setOnClickListener(v -> txtDivisiones.append("7"));
        btn8.setOnClickListener(v -> txtDivisiones.append("8"));
        btn9.setOnClickListener(v -> txtDivisiones.append("9"));
        btn0.setOnClickListener(v -> txtDivisiones.append("0"));
        btnPunto.setOnClickListener(v -> txtDivisiones.append(","));
        btnIgual.setOnClickListener(v -> {
            // Mantener vacío por ahora
        });
        btnX.setOnClickListener(v -> txtDivisiones.append("X"));
        btnY.setOnClickListener(v -> txtDivisiones.append("Y"));
        btnElvar.setOnClickListener(v -> txtDivisiones.append("^"));
        btnIntegral.setOnClickListener(v -> txtDivisiones.append("∫"));
        btnParentesis1.setOnClickListener(v -> txtDivisiones.append("("));
        btnParentesis2.setOnClickListener(v -> txtDivisiones.append(")"));
        btnValorAbsoluto.setOnClickListener(v -> txtDivisiones.append("|"));
        btnEuler.setOnClickListener(v -> txtDivisiones.append("e"));
        btnSeno.setOnClickListener(v -> txtDivisiones.append("sen"));
        btnCoseno.setOnClickListener(v -> txtDivisiones.append("cos"));
        btnLogaritmo.setOnClickListener(v -> txtDivisiones.append("ln"));
        btnPi.setOnClickListener(v -> txtDivisiones.append("π"));
        btnMulti.setOnClickListener(v -> txtDivisiones.append("*"));
        btnSuma.setOnClickListener(v -> txtDivisiones.append("+"));
        btnResta.setOnClickListener(v -> txtDivisiones.append("-"));
        btnDivision.setOnClickListener(v -> txtDivisiones.append("/"));
        btnRaiz.setOnClickListener(v -> txtDivisiones.append("√"));
        btnBorrar.setOnClickListener(view -> txtDivisiones.append(""));
        btnFlecha.setOnClickListener(view -> txtDivisiones.append("➜"));
        btnInfinito.setOnClickListener(view -> txtDivisiones.append("∞"));
        btnAC.setOnClickListener(v -> txtDivisiones.setText(""));


        btnBorrar.setOnClickListener(view -> {
            String textoActual = txtDivisiones.getText().toString();
            if (!textoActual.isEmpty()) {
                String nuevoTexto = textoActual.substring(0, textoActual.length() - 1);
                txtDivisiones.setText(nuevoTexto);
            }
        });

        String[] opcionesIntegrales = new String[]{
                "Seleccione un método",  // Opción por defecto
                "Por Sustitución",
                "Por partes",
                "Potencias de funciones trigonométricas",
                "Sustituciones trigonométricas",
                "Integrales impropias",
                "Movimiento rectilíneo",
                "Área",
                "Volúmenes de sólidos: Métodos de rebanadas y de cascarones",
                "Área de una superficie de revolución",
                "Valor promedio de una función",
                "Centros de masa y Centroides",
                "Límites y continuidad de funciones de varias variables",
                "Derivadas parciales y Diferencial total y exacta",
                "Regla de Cadena, Diferenciales y Extremos de funciones de dos Variables"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,  // Layout para cada item cuando el spinner está cerrado
                opcionesIntegrales
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIntegrales.setAdapter(adapter);

        spinnerIntegrales.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) { // Si no es la opción por defecto
                    String seleccion = parent.getItemAtPosition(position).toString();
                    Toast.makeText(getApplicationContext(),
                            "Método seleccionado: " + seleccion,
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Manejar el caso cuando no se selecciona nada
            }
        });


        btnIgual.setOnClickListener(v -> {
            String seleccion = spinnerIntegrales.getSelectedItem().toString();
            String expresion = txtDivisiones.getText().toString();

            // Si no se ha seleccionado un método específico, realizar cálculo normal
            if (seleccion.equals("Seleccione un método")) {
                try {
                    double resultado = Calculadora.evaluar(expresion);
                    txtDivisiones.setText(String.valueOf(resultado));
                } catch (Exception e) {
                    Toast.makeText(CalculadoraActivity.this,
                            "Error en la expresión", Toast.LENGTH_SHORT).show();
                }
                return;
            }


            switch (seleccion) {
                case "Por Sustitución":
                    // Función para resolver integrales por sustitución

                    break;

                case "Por partes":
                    // Función para resolver integrales por partes
                    break;

                case "Potencias de funciones trigonométricas":
                    // Función para resolver integrales de potencias de funciones trigonométricas
                    break;

                case "Sustituciones trigonométricas":
                    // Función para resolver integrales con sustituciones trigonométricas
                    break;

                case "Integrales impropias":
                    try {
                        String funcion = txtDivisiones.getText().toString();
                        String limInfStr = txtLimiteInferior.getText().toString();
                        String limSupStr = txtLimiteSuperior.getText().toString();

                        // Usaremos un número fijo de divisiones para la precisión
                        int divisiones = 1000; // Valor predeterminado para precisión

                        if (funcion.isEmpty() || limInfStr.isEmpty() || limSupStr.isEmpty()) {
                            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        // Convertir límites a double, manejando infinito
                        double limiteInferior;
                        double limiteSuperior;

                        // Procesar límite inferior
                        if (limInfStr.equals("-∞") || limInfStr.equalsIgnoreCase("-infinito")) {
                            limiteInferior = -1000000; // Aproximación de infinito negativo
                        } else {
                            limiteInferior = Double.parseDouble(limInfStr);
                        }

                        // Procesar límite superior
                        if (limSupStr.equals("∞") || limSupStr.equalsIgnoreCase("infinito")) {
                            limiteSuperior = 1000000; // Aproximación de infinito positivo
                        } else {
                            limiteSuperior = Double.parseDouble(limSupStr);
                        }

                        // Calcular la integral usando el método del trapecio
                        double h = (limiteSuperior - limiteInferior) / divisiones;
                        double suma = 0.0;

                        for (int i = 0; i <= divisiones; i++) {
                            double x = limiteInferior + i * h;

                            // Evaluar la función usando exp4j
                            Expression e = new ExpressionBuilder(funcion)
                                    .variables("x", "y")
                                    .build()
                                    .setVariable("x", x)
                                    .setVariable("y", 0); // y se mantiene en 0 por defecto

                            double valor = e.evaluate();

                            if (i == 0 || i == divisiones) {
                                suma += valor / 2;
                            } else {
                                suma += valor;
                            }
                        }

                        double resultado = suma * h;

                        // Mostrar el resultado en txtResultado
                        txtResultado.setText(String.format("%.6f", resultado));

                    } catch (NumberFormatException e) {
                        Toast.makeText(this, "Error en el formato de los números", Toast.LENGTH_SHORT).show();
                    } catch (IllegalArgumentException e) {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(this, "Error en el cálculo: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    break;

                case "Movimiento rectilíneo":
                    // Función para resolver problemas de movimiento rectilíneo

                    break;

                case "Área":
                    // Función para calcular el área bajo la curva

                    break;

                case "Volúmenes de sólidos: Métodos de rebanadas y de cascarones":
                    // Función para calcular volúmenes de sólidos por rebanadas o cascarones

                    break;

                case "Área de una superficie de revolución":
                    // Función para calcular área de una superficie de revolución

                    break;

                case "Valor promedio de una función":
                    // Función para calcular el valor promedio de una función

                    break;

                case "Centros de masa y Centroides":
                    // Función para calcular centros de masa y centroides

                    break;

                case "Límites y continuidad de funciones de varias variables":
                    // Función para resolver límites y continuidad en funciones de varias variables

                    break;

                case "Derivadas parciales y Diferencial total y exacta":
                    // Función para resolver derivadas parciales y diferencial total y exacta

                    break;

                case "Regla de Cadena, Diferenciales y Extremos de funciones de dos Variables":
                    // Función para aplicar la regla de cadena, diferenciales y extremos

                    break;

                default:
                    // Función por defecto

                    break;
            }
        });
    }

    private Function<Double, Double> parsearFuncion(String expresion) {
        return x -> {
            // Reemplazar la variable x en la expresión
            String expr = expresion.replace("X", x.toString())
                    .replace("x", x.toString());

            try {
                // Usar el evaluador existente para calcular el resultado
                return Calculadora.evaluar(expr);
            } catch (Exception e) {
                throw new IllegalArgumentException("Error al evaluar la función: " + e.getMessage());
            }
        };
    }

    private double calcularIntegralImpropia(Function<Double[], Double> funcion, double limiteInferior, double limiteSuperior, int divisiones) {
        double h = (limiteSuperior - limiteInferior) / divisiones;
        double suma = 0.0;

        for (int i = 0; i < divisiones; i++) {
            double x = limiteInferior + i * h;
            double y = 0; // Puedes modificar esto según necesites
            suma += funcion.apply(new Double[]{x, y}) * h;
        }

        return suma;
    }

    private double evaluarExpresion(String expression, double x, double y) {
        try {
            // Crear la expresión usando ExpressionBuilder de exp4j
            Expression e = new ExpressionBuilder(expression)
                    .variables("x", "y") // Define las variables
                    .build()
                    .setVariable("x", x) // Asigna el valor de x
                    .setVariable("y", y); // Asigna el valor de y

            return e.evaluate();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al evaluar la expresión: " + e.getMessage());
        }
    }


    private static class Calculadora {

        public static void setValorX(double x) {}
        public static void setValorY(double y) {}

        public static double evaluar(String expresion) {
            try {
                expresion = preprocesarExpresion(expresion);
                return evaluarExpresion(expresion);
            } catch (Exception e) {
                return Double.NaN;
            }
        }

        private static String preprocesarExpresion(String expresion) {
            expresion = expresion.replace(" ", "");

            expresion = expresion.replace("X", "x");
            expresion = expresion.replace("Y", "y");
            expresion = expresion.replaceAll("(\\d)\\(", "$1*(");
            expresion = expresion.replaceAll("\\)(\\d)", ")*$1");
            expresion = expresion.replaceAll("\\)\\(", ")*(");

            if (expresion.startsWith("-")) {
                expresion = "0" + expresion;
            }

            return expresion;
        }

        private static double evaluarExpresion(String expresion) {
            int parentesis = 0;
            int pos = -1;
            for (int i = expresion.length() - 1; i >= 0; i--) {
                char c = expresion.charAt(i);
                if (c == ')') parentesis++;
                if (c == '(') parentesis--;
                if (parentesis == 0 && c == '^') {
                    pos = i;
                    break;
                }
            }

            if (pos > 0) {
                String base = expresion.substring(0, pos);
                String exponente = expresion.substring(pos + 1);
                return Math.pow(evaluarExpresion(base), evaluarExpresion(exponente));
            }
            parentesis = 0;
            pos = -1;
            for (int i = expresion.length() - 1; i >= 0; i--) {
                char c = expresion.charAt(i);
                if (c == ')') parentesis++;
                if (c == '(') parentesis--;
                if (parentesis == 0 && (c == '+' || (c == '-' && i > 0))) {
                    pos = i;
                    break;
                }
            }

            if (pos > 0) {
                String izquierda = expresion.substring(0, pos);
                String derecha = expresion.substring(pos + 1);
                if (expresion.charAt(pos) == '+') {
                    return evaluarExpresion(izquierda) + evaluarExpresion(derecha);
                } else {
                    return evaluarExpresion(izquierda) - evaluarExpresion(derecha);
                }
            }
            parentesis = 0;
            pos = -1;

            for (int i = expresion.length() - 1; i >= 0; i--) {
                char c = expresion.charAt(i);
                if (c == ')') parentesis++;
                if (c == '(') parentesis--;
                if (parentesis == 0 && (c == '*' || c == '/')) {
                    pos = i;
                    break;
                }
            }

            if (pos > 0) {
                String izquierda = expresion.substring(0, pos);
                String derecha = expresion.substring(pos + 1);
                if (expresion.charAt(pos) == '*') {
                    return evaluarExpresion(izquierda) * evaluarExpresion(derecha);
                } else {
                    double divisor = evaluarExpresion(derecha);
                    if (divisor == 0) throw new ArithmeticException("División por cero");
                    return evaluarExpresion(izquierda) / divisor;
                }
            }

            if (expresion.startsWith("sen")) {
                return Math.sin(evaluarExpresion(expresion.substring(3)));
            }
            if (expresion.startsWith("cos")) {
                return Math.cos(evaluarExpresion(expresion.substring(3)));
            }
            if (expresion.startsWith("ln")) {
                return Math.log(evaluarExpresion(expresion.substring(2)));
            }
            if (expresion.startsWith("√")) {
                return Math.sqrt(evaluarExpresion(expresion.substring(1)));
            }
            if (expresion.equals("π")) {
                return Math.PI;
            }
            if (expresion.equals("e")) {
                return Math.E;
            }

            if (expresion.startsWith("(") && expresion.endsWith(")")) {
                return evaluarExpresion(expresion.substring(1, expresion.length() - 1));
            }

            try {
                return Double.parseDouble(expresion);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Expresión inválida: " + expresion);
            }
        }
    }
}