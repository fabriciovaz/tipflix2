package com.example.fabriciovaz.bottomnavigation2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import Adapter.MovieAdapter;
import Common.Common;
import Model.Movie;
import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
    public static Fragment1 newInstance() {
        Fragment1 fragment = new Fragment1();
        return fragment;
    }


    FeatureCoverFlow coverFlow;
    MovieAdapter adapter;
    TextSwitcher mTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        initData();
        adapter = new MovieAdapter(Common.movieList, getContext());
        coverFlow = (FeatureCoverFlow) view.findViewById(R.id.coverFlow);
        mTitle = (TextSwitcher) view.findViewById(R.id.mtitle);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                TextView text = (TextView)inflater.inflate(R.layout.layout_title,null);
                return text;
            }
        });
       coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(Common.movieList.get(position).getTitle());

            }

            @Override
            public void onScrolling() {

            }
        });
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle b = new Bundle();
                b.putInt("a",i);
                Intent intent = new Intent(getContext(),MovieDetail.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });



        return view;
    }



    private void initData() {
        Common.movieList.add(new Movie("Batman vs Superman","https://www.kveller.com/wp-content/uploads/2016/05/BATMAN-SUPERMAN.jpg","O confronto entre Superman e Zod em Metrópolis fez com que a população mundial se dividisse acerca da existência de extraterrestres na Terra. Enquanto muitos consideram o Superman como um novo deus, há aqueles que consideram extremamente perigoso que haja um ser tão poderoso sem qualquer tipo de controle. Bruce Wayne é um dos que acreditam nesta segunda hipótese. Com isso, sob o manto de um Batman violento e obcecado, eles se enfrentam enquanto o mundo se pergunta que tipo de herói precisa."));
        Common.movieList.add(new Movie("Mulher Maravilha","https://i.ytimg.com/vi/Xq-El--5qjI/maxresdefault.jpg","Treinada desde cedo para ser uma guerreira imbatível, Diana Prince nunca saiu da paradisíaca ilha em que é reconhecida como princesa das Amazonas. Quando o piloto Steve Trevor se acidenta e cai em uma praia do local, ela descobre que uma guerra sem precedentes está se espalhando pelo mundo e decide deixar seu lar certa de que pode parar o conflito. Lutando para acabar com todas as lutas, Diana percebe o alcance de seus poderes e sua verdadeira missão na Terra."));
        Common.movieList.add(new Movie("Capitão América: Guerra Civil","https://i1.wp.com/melhoresdomundo.net/wp-content/uploads/2015/05/civilwar.jpg","O ataque de Ultron faz com que os políticos decidam controlar os Vingadores, já que seus atos afetam toda a humanidade. Tal decisão coloca o Capitão América em rota de colisão com o Homem de Ferro."));
        Common.movieList.add(new Movie("Homem-Aranha","https://www.meridionalfm.com.br/midia/noticias/not_203e3c6f949dc4b364231c675ff99ddc.png","Depois de ser picado por uma aranha geneticamente modificada, Peter Parker ganha super poderes e as habilidades da aranha para se agarrar a qualquer superfície. Ele promete usá-los para combater o crime e começa a entender as palavras de seu querido tio Ben: com grandes poderes vêm grandes responsabilidades."));
        Common.movieList.add(new Movie("X-Men: Dias de Um Futuro Esquecido","https://www.blahcultural.com/wp-content/uploads/2014/10/x-men.jpg","Convencido de que os mutantes são uma ameaça para a humanidade, o Dr. Bolivar Trask desenvolve os Sentinelas, gigantescos robôs, que os perseguem impiedosamente. Os poucos sobreviventes têm que viver escondidos. Entre eles está Wolverine, que viaja no tempo, rumo aos anos 1970, a fim de impedir que este futuro trágico para os mutantes se torne realidade."));

    }
}
