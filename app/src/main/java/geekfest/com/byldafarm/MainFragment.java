package geekfest.com.byldafarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by prempal on 22/3/15.
 */
public class MainFragment extends Fragment {

    String stringToPassInSQL = "", location = "";
    float maxProfit;
    private Button submitButton, buildFarmButton;
    private EditText farmAreaEdTxt,farmBudgetEdTxt;
    private Spinner farmLocation;
    private ProgressBar progressBar;

    public static final String[] districts = {"bastar","bilaspur","dantewara","dhamtari","durg","janjgir-champa","jashpur","kanker","kawardha","kabirdham","korba","koriya","mahasmund","raigarh","raipur","raj","nandgaon","sarguja","bastar","bilaspur","dantewara","dhamtari","durg","janjgir-champa","jashpur","kanker","kawardham","korba","koriya","mahasmund","raigarh","raipur","raj","nandgaon","sarguja","bastar","bilaspur","ahmedabad","ahmedabad","amreli","amreli","anand","anand","banas","kantha","banas","kantha","bhavnagar","bhavnagar","broach","broach","dangs","dohad","gandhinagar","gandhinagar","jamnagar","jamnagar","junagarh","junagarh","kheda","kheda","kutch","kutch","mehsana","mehsana","narmada","navsari","panch","mahals","panch","mahals","panch","mahals","patan","patan","porbandar","porbandar","rajkot","rajkot","sabarkantha","sabarkantha","surat","surat","surendranagar","surendranagar","tapi","tapi","vadodara","vadodara","valsad","ahmedabad","amreli","anand","banas","kantha","bhavnagar","broach","gandhinagar","jamnagar","junagarh","kheda","kutch","mehsana","narmada","panch","mahals","patan","porbandar","rajkot","sabarkantha","surendranagar","vadodara","ahmednagar","ahmednagar","akola","akola","akola","amravati","amravati","amravati","aurangabad","aurangabad","aurangabad","beed","beed","beed","buldhana","buldhana","buldhana","chandrapur","chandrapur","dhule","dhule","dhule","gadchiroli","hingoli","hingoli","hingoli","jalana","jalana","jalana","jalgaon","jalgaon","jalgaon","kolhapur","kolhapur","latur","latur","latur","mandurbar","mandurbar","mandurbar","nagpur","nagpur","nanded","nanded","nasik","nasik","nasik","osmanabad","osmanabad","osmanabad","parbhani","parbhani","parbhani","pune","pune","sangli","sangli","sangli","satara","satara","satara","solapur","solapur","solapur","wardha","wardha","washim","washim","washim","yavatmal","yavatmal","yavatmal","ahmednagar","akola","amravati","aurangabad","beed","buldhana","chandrapur","dhule","gadchiroli","hingoli","jalana","jalgaon","kolhapur","latur","mandurbar","nagpur","nanded","nasik","osmanabad","parbhani","pune","sangli","satara","solapur","wardha","washim","yavatmal","agra","agra","agra","agra","aligarh","aligarh","aligarh","aligarh","allahabad","allahabad","allahabad","allahabad","ambedkar","ngr.","ambedkar","ngr.","ambedkar","ngr.","ambedkar","ngr.","ambedkar","ngr.","auraiya","auraiya","auraiya","auraiya","azamgarh","azamgarh","azamgarh","azamgarh","azamgarh","badaun","badaun","badaun","badaun","bagpat","bagpat","bahraich","bahraich","bahraich","bahraich","ballia","ballia","ballia","ballia","ballia","balrampur","balrampur","balrampur","balrampur","banda","banda","banda","barabanki","barabanki","barabanki","barabanki","barabanki","bareilly","bareilly","bareilly","bareilly","basti","basti","basti","basti","bijnor","bijnor","bijnor","bullandshahr","bullandshahr","bullandshahr","bullandshahr","chandauli","chandauli","chandauli","chandauli","chitrakut","chitrakut","chitrakut","deoria","deoria","deoria","deoria","deoria","etah","etah","etah","etah","etawah","etawah","etawah","etawah","faizabad","faizabad","faizabad","faizabad","farrukhabad","farrukhabad","farrukhabad","farrukhabad","fatehpur","fatehpur","fatehpur","fatehpur","firozabad","firozabad","firozabad","firozabad","g.buddha","ngr.","g.buddha","ngr.","g.buddha","ngr.","ghaziabad","ghaziabad","ghaziabad","ghaziabad","ghazipur","ghazipur","ghazipur","ghazipur","ghazipur","gonda","gonda","gonda","gonda","gorakhpur","gorakhpur","gorakhpur","gorakhpur","gorakhpur","hamirpur","hamirpur","hamirpur","hardoi","hardoi","hardoi","hardoi","j.b.phule","ngr.","j.b.phule","ngr.","j.b.phule","ngr.","j.b.phule","ngr.","jalaun","jalaun","jalaun","jalaun","jaunpur","jaunpur","jaunpur","jaunpur","jhansi","jhansi","jhansi","kannauj","kannauj","kannauj","kannauj","kanpur","city","kanpur","city","kanpur","city","kanpur","city","kaushambi","kaushambi","kaushambi","kaushambi","kheri","kheri","kheri","kheri","kheri","kushi","ngr.","kushi","ngr.","kushi","ngr.","kushi","ngr.","kushi","ngr.","lalitpur","lalitpur","lucknow","lucknow","lucknow","lucknow","lucknow","mahamaya","nagar","mahamaya","nagar","mahamaya","nagar","mahamaya","nagar","maharahganj","maharahganj","maharahganj","mahoba","mahoba","mahoba","mainpuri","mainpuri","mainpuri","mainpuri","mathura","mathura","mathura","mau","mau","mau","mau","meerut","meerut","meerut","meerut","mirzapur","mirzapur","mirzapur","mirzapur","mixed","crops","mixed","crops","mixed","crops","mixed","crops","moradabad","moradabad","moradabad","moradabad","muzaffarnagar","muzaffarnagar","muzaffarnagar","pilibhit","pilibhit","pilibhit","pratapgarh","pratapgarh","pratapgarh","pratapgarh","raebareli","raebareli","raebareli","raebareli","raebareli","ramabai","nagar","ramabai","nagar","ramabai","nagar","ramabai","nagar","ramabai","nagar","rampur","rampur","rampur","rampur","s.ravi","das","ngr.","s.ravi","das","ngr.","s.ravi","das","ngr.","saharanpur","saharanpur","saharanpur","sant","kabir","ngr.","sant","kabir","ngr.","sant","kabir","ngr.","sant","kabir","ngr.","sant","kabir","ngr.","shahjahanpur","shahjahanpur","shahjahanpur","shahjahanpur","shivasti","shivasti","shivasti","siddharth","ngr.","siddharth","ngr.","siddharth","ngr.","sitapur","sitapur","sitapur","sitapur","sitapur","sonbhadra","sonbhadra","sonbhadra","sonbhadra","sultanpur","sultanpur","sultanpur","sultanpur","sultanpur","unnao","unnao","unnao","unnao","unnao","varanasi","varanasi","varanasi","varanasi","dantewara","dhamtari","durg","janjgir-champa","jashpur","kanker","kawardha","kabirdham","korba","koriya","mahasmund","raigarh","raipur","raj","nandgaon","sarguja"};

    public MainFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        submitButton = (Button) rootView.findViewById(R.id.submit);
        farmAreaEdTxt = (EditText) rootView.findViewById(R.id.farm_area);
        farmBudgetEdTxt = (EditText) rootView.findViewById(R.id.farm_budget);
        farmLocation = (Spinner) rootView.findViewById(R.id.farm_location);
        String[] unique = new HashSet<String>(Arrays.asList(districts)).toArray(new String[0]);
        Collections.sort(Arrays.asList(unique));
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, unique);
        farmLocation.setAdapter(dataAdapter);
        buildFarmButton = (Button) rootView.findViewById(R.id.build_a_farm);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);

        if(!Utils.isConnectedToInternet(getActivity())){
            Toast.makeText(getActivity(),"The app requires Internet connectivity to function properly",Toast.LENGTH_SHORT).show();
        }

        ArrayList<String> cropsGrown = Utils.getSeason();

        stringToPassInSQL = "";

        for (int i = 0; i < cropsGrown.size(); i++) {
            if (i == cropsGrown.size() - 1) {
                stringToPassInSQL = stringToPassInSQL + "\'" + cropsGrown.get(i) + "\');";
            } else
                stringToPassInSQL = stringToPassInSQL + "\'" + cropsGrown.get(i) + "\', "; //"\' OR Season LIKE ";
        }
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()) {

                    final int farmBudget = Integer.parseInt(farmBudgetEdTxt.getText().toString());
                    final double farmArea = Double.parseDouble(farmAreaEdTxt.getText().toString());
                    location = farmLocation.getSelectedItem().toString();
                    final String sqlInput = "SELECT * FROM `nigga` WHERE District LIKE " + "\'" + location + "\'" + " AND Season IN (" + stringToPassInSQL;

                    Log.d("Raghav", sqlInput);
                    new QueryTask() {

                        @Override
                        protected void onPreExecute() {
                            progressBar.setVisibility(View.VISIBLE);
                        }


                        @Override
                        protected void onPostExecute(String stringResponse) {
                            try {

                                JSONArray jsonArray = new JSONArray(stringResponse);
                                ArrayList<Crop> crop = new ArrayList<Crop>();
                                int i = 0;
                                while (i < jsonArray.length() && i < 3) {
                                    crop.add(i, new Crop());
                                    crop.get(i).cropName = jsonArray.getJSONObject(i).getString("Crop");
                                    crop.get(i).seedCost = jsonArray.getJSONObject(i).getInt("SeedCost");
                                    crop.get(i).fertilizerCost = jsonArray.getJSONObject(i).getInt("Fertilizer");
                                    crop.get(i).irrigationCost = jsonArray.getJSONObject(i).getInt("Irrigation");
                                    crop.get(i).labourCost = jsonArray.getJSONObject(i).getInt("LabourCost");
                                    crop.get(i).sellingPrice = jsonArray.getJSONObject(i).getInt("SellingPrice");
                                    crop.get(i).costPrice = jsonArray.getJSONObject(i).getInt("CostPrice");
                                    i++;
                                }
                                FarmCalculationResult farmCalResult = AlgorithmTwoCrops.efficientFarm(farmBudget, farmArea, crop);

//                            for( i = 0; i < crop.size(); i++){
//                                if(i == 0){
//                                    crop.get(i).maxArea = farmCalResult.maxAreaCrop1;
//
//                                } else if (i == 1) {
//                                   crop.get(i).maxArea = farmCalResult.maxAreaCrop2;
//
//                                } else if (i ==2) {
//                                    crop.get(i).maxArea = farmCalResult.maxAreaCrop3;
//
//                                }
//                            }
//                            maxProfit = farmCalResult.totalProfit;
                                Log.d("Raghav", "" + maxProfit + "" + farmCalResult.maxAreaCrop1 + "" + farmCalResult.maxAreaCrop2 + "" + farmCalResult.maxAreaCrop3);
                                progressBar.setVisibility(View.GONE);

                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container, new ProfitFragment(crop, farmCalResult))
                                        .addToBackStack("profitFragment")
                                        .commit();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }.execute(sqlInput);


                }
            }
        });
        buildFarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()) {
                    final int farmBudget = Integer.parseInt(farmBudgetEdTxt.getText().toString());
                    final int farmArea = Integer.parseInt(farmAreaEdTxt.getText().toString());
                    location = farmLocation.getSelectedItem().toString();
                    final String sqlInput = "SELECT * FROM `nigga` WHERE District LIKE " + "\'" + location + "\'" + " AND Season IN (" + stringToPassInSQL;

                    Log.d("Raghav", sqlInput);
                    new QueryTask() {

                        @Override
                        protected void onPreExecute() {
                            progressBar.setVisibility(View.VISIBLE);
                        }


                        @Override
                        protected void onPostExecute(String stringResponse) {
                            try {

                                JSONArray jsonArray = new JSONArray(stringResponse);
                                ArrayList<Crop> crop = new ArrayList<Crop>();
                                int i = 0;
                                while (i < jsonArray.length() && i < 3) {
                                    crop.add(i, new Crop());
                                    crop.get(i).cropName = jsonArray.getJSONObject(i).getString("Crop");
                                    crop.get(i).seedCost = jsonArray.getJSONObject(i).getInt("SeedCost");
                                    crop.get(i).fertilizerCost = jsonArray.getJSONObject(i).getInt("Fertilizer");
                                    crop.get(i).irrigationCost = jsonArray.getJSONObject(i).getInt("Irrigation");
                                    crop.get(i).labourCost = jsonArray.getJSONObject(i).getInt("LabourCost");
                                    crop.get(i).sellingPrice = jsonArray.getJSONObject(i).getInt("SellingPrice");
                                    crop.get(i).costPrice = jsonArray.getJSONObject(i).getInt("CostPrice");
                                    i++;
                                }
                                Intent intent = new Intent(getActivity(), CustomMapActivity.class);
                                intent.putExtra("Area", farmAreaEdTxt.getText().toString());
                                intent.putExtra("Crops", crop);
                                startActivity(intent);
                                progressBar.setVisibility(View.GONE);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }.execute(sqlInput);
                }

            }
        });


        return rootView;
    }

    private boolean validate() {
        if (Utils.isEditTextEmpty(farmAreaEdTxt)) {
            farmAreaEdTxt.setError("Required");
            return false;
        }
        if (Utils.isEditTextEmpty(farmBudgetEdTxt)) {
            farmBudgetEdTxt.setError("Required");
            return false;
        }
        return true;
    }

}