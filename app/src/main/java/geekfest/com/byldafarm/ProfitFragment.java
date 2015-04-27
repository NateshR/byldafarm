package geekfest.com.byldafarm;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.PercentFormatter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfitFragment extends android.support.v4.app.Fragment {

    private PieChart mChart;
    private ArrayList<Crop> arrayList;

    public ProfitFragment(){

    }

    public ProfitFragment(ArrayList<Crop> crop) {
        arrayList = crop;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profit, container, false);
        mChart = (PieChart) rootView.findViewById(R.id.chart);
        mChart.setUsePercentValues(true);
        mChart.setHoleColorTransparent(true);
        mChart.setCenterText("Profit \n" + "Rs. 78296.6 ");
        setData(3, 100);
        mChart.setCenterTextSizePixels(50);
        TextView seed1 = (TextView) rootView.findViewById(R.id.aacostofseeds1);
        TextView fert1 = (TextView) rootView.findViewById(R.id.aafertilizer1);
        TextView irri1 = (TextView) rootView.findViewById(R.id.aairrigation1);
        TextView labor1 = (TextView) rootView.findViewById(R.id.aalabour1);
        seed1.setText("Seed cost price(1) = Rs. " +arrayList.get(0).costPrice);
        fert1.setText("Fertilizer price(1) = Rs. " +arrayList.get(0).fertilizerCost);
        irri1.setText("Irrigation price(1) = Rs. " +arrayList.get(0).irrigationCost);
        labor1.setText("Labor price(1) = Rs. " +arrayList.get(0).labourCost);
        TextView seed2 = (TextView) rootView.findViewById(R.id.aacostofseeds2);
        TextView fert2 = (TextView) rootView.findViewById(R.id.aafertilizer2);
        TextView irri2 = (TextView) rootView.findViewById(R.id.aairrigation2);
        TextView labor2 = (TextView) rootView.findViewById(R.id.aalabour2);
        seed2.setText("Seed cost price(2) = Rs. " +arrayList.get(1).costPrice);
        fert2.setText("Fertilizer price(2) = Rs. " +arrayList.get(1).fertilizerCost);
        irri2.setText("Irrigation price(2) = Rs. " +arrayList.get(1).irrigationCost);
        labor2.setText("Labor price(2) = Rs. " +arrayList.get(1).labourCost);
        TextView seed3 = (TextView) rootView.findViewById(R.id.aacostofseeds3);
        TextView fert3 = (TextView) rootView.findViewById(R.id.aafertilizer3);
        TextView irri3 = (TextView) rootView.findViewById(R.id.aairrigation3);
        TextView labor3 = (TextView) rootView.findViewById(R.id.aalabour3);
        seed3.setText("Seed cost price(3) = Rs. " +arrayList.get(2).costPrice);
        fert3.setText("Fertilizer price(3) = Rs. " +arrayList.get(2).fertilizerCost);
        irri3.setText("Irrigation price(3) = Rs. " +arrayList.get(2).irrigationCost);
        labor3.setText("Labor price(3) = Rs. " +arrayList.get(2).labourCost);
        return rootView;
    }
    private void setData(int count, float range) {
        float mult = range;

        ArrayList<Entry> yVals1 = new ArrayList<Entry>();
        yVals1.add(new Entry((float) 72.0, 0));
        yVals1.add(new Entry((float) 19.4, 1));
        yVals1.add(new Entry((float) 8.6, 2));
        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < count + 1; i++)
            xVals.add(mParties[i % mParties.length]);
        PieDataSet dataSet = new PieDataSet(yVals1, "");
        dataSet.setSliceSpace(3f);
// add a lot of colors
        ArrayList<Integer> colors = new ArrayList<Integer>();
//        for (int c : ColorTemplate.VORDIPLOM_COLORS)
//            colors.add(c);
//        for (int c : ColorTemplate.JOYFUL_COLORS)
//            colors.add(c);
        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);
        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);
        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        mChart.setData(data);
// undo all highlights
        mChart.highlightValues(null);
        mChart.invalidate();
    }
    protected String[] mParties = new String[] {
            "Bajra","Maize","Sugarcane"};
}
