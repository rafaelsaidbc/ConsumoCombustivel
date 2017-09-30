package rafasaid.com.br.consumocombustivel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Consumo extends AppCompatActivity {

    private EditText mDistancia; //cria a variável mDistância tendo uma EditText como referência
    private EditText mConsumo; //cria a variável mConsumo tendo uma EditText como referência
    private EditText mPreco; //cria a variável mPreco tendo uma EditText como referência
    private Button mBtnCalcular; //cria uma referência a um botão

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consumo);

        //estabelece que a referência da mDistancia é o EditText R.id.distancia
        mDistancia = (EditText) findViewById(R.id.distancia);

        //estabelece que a referência da mConsumo é o EditText R.id.consumo
        mConsumo = (EditText) findViewById(R.id.consumo);

        //estabelece que a referência da mPreco é o EditText R.id.preco
        mPreco = (EditText) findViewById(R.id.preco);

        //estabelece que a referência do mBtnCalcular é o Button R.id.btnCalcular
        mBtnCalcular = (Button) findViewById(R.id.btnCalcular);

        //chama o Button mBtnCalcular e faz as operações que estão dentro das {} do método
        mBtnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //chamado ao clicar no botão Calcular

                //define a String distancia pegando a referência mDistancia transformando-a de um
                //EditText para String com os parâmetros passados .getTex().toString();
                String distancia = mDistancia.getText().toString();

                //define a String consumo pegando a referência mConsumo transformando-a de um
                //EditText para String com os parâmetros passados .getTex().toString();
                String consumo = mConsumo.getText().toString();

                //define a String preco pegando a referência mPreco transformando-a de um
                //EditText para String com os parâmetros passados .getTex().toString();
                //o preco deve ser passado no formato 0.00, utilizando ponto e não vírgula
                String preco = mPreco.getText().toString();

                //cria o double km tendo como referência a String distancia, que é transformada em
                //double através dos parâmetros passados Double.parseDouble();
                double km = Double.parseDouble(distancia);

                //cria o double media tendo como referência a String consumo, que é transformada em
                //double através dos parâmetros passados Double.parseDouble();
                double media = Double.parseDouble(consumo);

                //cria o double custo tendo como referência a String preco, que é transformada em
                //double através dos parâmetros passados Double.parseDouble();
                double custo = Double.parseDouble(preco);

                //cria o double gasto fazendo o cálculo passado [(km / media) * custo];
                double gasto = (km / media) * custo;

                //DecimalFormat cria uma variável decimal definindo o limite de caracteres após
                //a vírgula, neste caso dois caracteres "0.00"
                DecimalFormat decimal = new DecimalFormat("0.00");

                //cria a String total formatando o double gasto com os parâmetros passados
                //decimal.format(); decimal é a variável de DecimalFormat criada acima
                String total = decimal.format(gasto);

                //cria a TextView custoTotal colocando-a no local indicado por R.id.gastoTotal
                TextView custoTotal = (TextView) findViewById(R.id.gastoTotal);
                //pega a TextView custoTotal e coloca como a String total, que foi formatada acima
                //para ter somente duas casas decimais.
                custoTotal.setText(total);
            }
        });
    }
}
