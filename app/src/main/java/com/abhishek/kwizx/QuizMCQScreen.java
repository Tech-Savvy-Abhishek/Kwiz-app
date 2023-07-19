package com.abhishek.kwizx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizMCQScreen extends AppCompatActivity {
    public static ArrayList<ModelClass> list;
    CountDownTimer countDownTimer;
    int timerValue=20;
    ProgressBar progressBar;

    List<ModelClass> allQuestionsList;
    ModelClass modelClass;
    int index=0;
    TextView card_question,optiona,optionb,optionc,optiond;
    CardView cardOA,cardOB,cardOC,cardOD;
    int correctCount=0;
    int wrongCount=0;
    LinearLayout next_btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apt_quiz);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.secondary_quizx));


        question();

        hooks();

        allQuestionsList = list;
        Collections.shuffle(allQuestionsList);
        modelClass = list.get(index);


        next_btn.setClickable(false);

        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {

                timerValue = timerValue - 1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {

                Dialog dialog = new Dialog(QuizMCQScreen.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialog);

                dialog.findViewById(R.id.btn_tryAgain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(QuizMCQScreen.this, MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                });
                dialog.show();
            }


        }.start();
        setAllData();


    }

    private void setAllData() {
        card_question.setText(modelClass.getQuestion());
        optiona.setText(modelClass.getoA());
        optionb.setText(modelClass.getoB());
        optionc.setText(modelClass.getoC());
        optiond.setText(modelClass.getoD());
    }

    public void question()
    {
        Intent i=getIntent();
        int choice=i.getIntExtra(ChooseCategoryQuizScreen.key,404);
        switch(choice)
        {
            case 1:
            {
                aptQuiz();
                break;
            }

            case 2:
            {
                phyQuiz();
                break;
            }

            case 3:
            {
                chemQuiz();
                break;
            }

            case 4:
            {
                bioQuiz();
                break;
            }

            case 5:
            {
                geoQuiz();
                break;
            }
        }





    }



    public void aptQuiz()
    {
        list=new ArrayList<>();

        list.add(new ModelClass("Were you a bird, you ______________ in the sky","would fly","shall fly","should fly","shall have flown","would fly"));
        list.add(new ModelClass("(1015)^2","1040125","1030225","1050125","1025125","1030225"));
        list.add(new ModelClass("Which one is NOT divisible by 3 ?","5271","6291","4372","8952","4372"));
        list.add(new ModelClass("The least perfect square, which is divisible by each of 15, 20 and 36 is:","1200","800","1000","900","900"));
        list.add(new ModelClass("Sum of the age of 4 childeren born at interval of 4 years is 36. What is the age of youngest child?","2 years","3 years","4 years","5 years","3 years"));
        list.add(new ModelClass("A is 5 years older than B who is thrice as old as C. If the total of ages of A, B and C is 40, then how old is C ?","6","7","5","8","5"));
        list.add(new ModelClass("At present, the ratio between ages of Ram and Shyam is 6:5 respectively. After 7 years, Shyam’s age will be 32 years. What is the present age of Ram?","32","40","30","36","30"));
        list.add(new ModelClass("How many terms are there in 3,9,27,81........531441?","25","12","13","14","12"));
        list.add(new ModelClass("7 + 72 + 73...........76 =?","140136","142156","133256","137256","137256"));
        list.add(new ModelClass("If the average of four consecutive odd numbers is 16, find the smallest of these numbers?","5","7","13","11","13"));
        list.add(new ModelClass("If the sum of two numbers is 13 and the sum of their square is 85. Find the numbers?","6 & 7","5 & 8","4 & 9","3 & 10","6 & 7"));
        list.add(new ModelClass("Find a positive number which when increased by 16 is equal to 80 times the reciprocal of the number","20","-4","-10","4","4"));
        list.add(new ModelClass("A person has 4 coins each of different denominations. What is the number of different sums of money  the person can form(using one or more coins at a time)? ","16","15","12","11","15"));
        list.add(new ModelClass("If the value of x lies between 0 and 1, which of the following is the largest?","X","x^2","-x","1/x","1/x"));
        list.add(new ModelClass("If the radius of a circle is diminished by 10%, then its area is diminished by:","10%","19%","20%","36%","19%"));
        list.add(new ModelClass("At what time after 4.00 p.m. is the minute's hand clock exactly aligned with the hour hand?","4:21:49.5","4:27:49.5","3:21:49.5","4:21:44.5","4:21:49.5"));
        list.add(new ModelClass("Thirty men take 20 days to complete a job working 9 hours a day. How many hours a day should 40 men  work to complete the job?","8 hrs","71/2 hrs","7 hrs","9 hrs","71/2 hrs"));
        list.add(new ModelClass("A man offers his at 5% misfortune. On the off chance that he offers it for Rs. 80 more, He picks up 5%. The expense cost of the is:","1600","1200","1000","800","800"));
        list.add(new ModelClass("The expense cost of an Rs 100 stock at 4 discounts, when financier is 1/4%, is:","Rs 96","Rs 96.25","Rs 95.75","Rs 104.25","Rs 96.25"));
        list.add(new ModelClass(" A man puts resources into a 9/2% stock at 96. The interest got by him is","Rs 4%","Rs 4.5","Rs 4.69%","Rs 0.5%","Rs 4.69%"));

    }

    public void phyQuiz()
    {
        list=new ArrayList<>();



        list.add(new ModelClass("The speed of a particle moving in a circle is increasing. The dot product of its acceleration and velocity is:","positive","may be +ve or –ve","zero","negative","positive"));
        list.add(new ModelClass("If Youngs double slit experiment, is performed in water:", "the fringe width will increase", "the fringe width will decrease", "the fringe width will remain unchanged", "there will be no fringe","the fringe width will decrease"));
        list.add(new ModelClass("If a metal wire of length L, having area of cross-section A and Youngs modulus Y, behaves as a spring of spring constant k. The value of k is:", "YA/L","YA/2L","YL/A", "2YA/L","YA/L"));
        list.add(new ModelClass("A positive charge is moving upwards in a magnetic field which is towards north. The particle will be deflected towards:", "west", "north", "south", "east","west"));
        list.add(new ModelClass("The time period of a simple pendulum at the centre of earth is:", "zero", "infinite", "less than zero","none of these","infinite"));

        list.add(new ModelClass("What happen to the elastic property of a substance after annealing (cooling slowly after heating)?", "Remains as such", "Decreases", "Becomes zero", "Increases","Decreases"));
        list.add(new ModelClass("The most efficient heat engine is one which is:","reversible","driven by high speed diesel","irreversible","none of the above","reversible"));
        list.add(new ModelClass("A train runs past a telegraph pole in 15 second, and through a tunnel 450 metre long in 45 s. The length of the train is","325 m","450 m","425 m","225 m","225 m"));
        list.add(new ModelClass("In which layer of the atmosphere the aurora is created?","Troposphere","Stratosphere","Mesosphere","Thermosphere","Thermosphere"));
        list.add(new ModelClass("What is the name of the most radioactive isotope on the planet?","Rad 226","Uranus 235","Polonium 210","Plutonium 244","Polonium 210"));

        list.add(new ModelClass("Where does water boil at the temperature 37 °C (98.6 °F)?","in a microwave oven","at the Armstrong's line","at the Kármán line","on Mount Everest","at the Armstrong's line"));
        list.add(new ModelClass("How many dimensions does string theory assume?","4","11","10","3","10"));
        list.add(new ModelClass("The Tenth Dimension describes:","All possible time lines for all possible universes as a single point.","Infinity","The action of bending two 8 dimensional lines to allow travel between each eight dimensional space","All possible paths for our universe as a collection of lines","All possible time lines for all possible universes as a single point."));
        list.add(new ModelClass("When we apply reverse bias to a junction diode, it:","greatly increases the minority carrier current","raises the potential barrier","greatly increases the majority carrier current","lowers the potential barrier","raises the potential barrier"));
        list.add(new ModelClass("The time period of an earths satellite in circular orbit is independent of:","neither the mass of the satellite nor the radius of its orbit","radius of its orbit","both the mass and radius of the orbit","the mass of the satellite","the mass of the satellite"));

        list.add(new ModelClass("Which among the following temperature scale is based upon absolute zero?","Celsius","Fahrenheit","Kelvin","Rankine","Kelvin"));
        list.add(new ModelClass("When two bodies, of different mass, are acted upon by the same force for the same time, then both bodies acquire the:","Same velocity","Same momentum","Same acceleration","All of the above","Same momentum"));
        list.add(new ModelClass("What is the relationship between Kinetic and limiting friction?","Kinetic friction is slightly greater than limiting friction","Kinetic friction is slightly less than limiting friction","Kinetic friction is equal to limiting friction","No relationship","Kinetic friction is slightly less than limiting friction"));
        list.add(new ModelClass("What is the rate of acceleration produced by 1 dyne force acting on a body of mass 1 gram?","9.8 m s-2","1 m s-2","1 cm s-2","9.8 cm s-2",""));
        list.add(new ModelClass("What is the effect of increase in radius of orbit on the binding energy of a satellite?","it increases"," it decreases","It remains the same","None of the above"," it decreases"));




    }

    public void chemQuiz()
    {
        list=new ArrayList<>();




        list.add(new ModelClass("Which of the following are isoelectronic species?","H+ HH-","Li+ Na+ K+","C1- Br- I"," F- Ne Na+"," F- Ne Na+"));
        list.add(new ModelClass("Molecular ions are formed by passing","High energy electron beam"," – particle","X-rays","All of the above","All of the above"));
        list.add(new ModelClass("The number of peaks obtained in mass spectrometry shows","Relative abundance","The average mass of the element","Number of isotopes","Relative isotopic mass","Number of isotopes"));
        list.add(new ModelClass("The empirical formula of chloroform is","CHC13","CH3C1","CC14","CH2 C12","CHC13"));
        list.add(new ModelClass("Which of the following ion formation is always exothermic?","Uni-positive","Uni-negative","Di-negative","Di-positive","Uni-negative"));

        list.add(new ModelClass("Organic compounds that are essentially nonpolar and exhibit weak intermolecular forces have","Low melting points","Low vapour pressure","High boiling points","High electrical conductivity","Low melting points"));
        list.add(new ModelClass("First organic compound synthesized in laboratory was","Tartaric acid","Urea","Ethyl alcohol","Methanol","Urea"));
        list.add(new ModelClass("Compounds having same molecular formula but differ in structural formula are called","Polymer","Monomer","Isomer","Allotropes","Isomer"));
        list.add(new ModelClass("In sp3 hybridization, the expected geometry of molecules will be","Square planar","Trigonal pyramidal","Tetrahedral","Linear","Tetrahedral"));
        list.add(new ModelClass("The fractional distillation of petroleum produces gasoline up to","10%","15%","20%","30%","20%"));

        list.add(new ModelClass("Ozone is formed by ______ dissociation of molecular oxygen into individual oxygen atoms.","thermochemical","photochemical","thermal","ionic","photochemical"));
        list.add(new ModelClass("Which of the following are the principle laws of photochemistry?","Raoult’s and Dalton’s law","Raoult’s and Henry’s law","Lambert’s and Beer’s law","Grothus-Draper and Stark-Einstein law","Grothus-Draper and Stark-Einstein law"));
        list.add(new ModelClass("Vision is initiated by a photochemical reaction of ______","Hydrogen Chloride","Rhodopsin","Mercapton","Enzymes","Rhodopsin"));
        list.add(new ModelClass("Which of the following is not an example of a natural biodegradable polymer?","Collagen","Lignin","Polyvinyl alcohol","Natural rubber","Polyvinyl alcohol"));
        list.add(new ModelClass("The half life period of first order reaction is 15 min. Its rate constant will be equal to ___________","0.0462 min-1","0.462 min-1","0.00462 min-1","0.562 min-1","0.0462 min-1"));

        list.add(new ModelClass("In how many ways –CH3 protons can couple with the protons on adjacent carbon atom relative to the external field","1","2","3","4","4"));
        list.add(new ModelClass("Which is true for a spontaneous endothermic process?","ΔH<0","ΔG<0","ΔS<0","ΔG>0","ΔG<0"));
        list.add(new ModelClass("Pumping of water uphill is","Non-spontaneous process","Spontaneous process","Irreversible process","Reversible process","Non-spontaneous process"));
        list.add(new ModelClass("State function the macroscopic property of system depends upon","Path of reaction","Initial state","Final state","Initial and final state","Initial and final state"));
        list.add(new ModelClass("The lattice energy of NaCl is","+787 KJ/mole","790 KJ/mole","780 KJ/mole","787 J/mole","790 KJ/mole"));


    }

    public void bioQuiz()
    {

        list=new ArrayList<>();


        list.add(new ModelClass("Down Syndrome is also known as:","Edwards syndrome","Patau syndrome","Mongolism","None of the above","Mongolism"));
        list.add(new ModelClass("Which among the following acid is NOT a Vitamin ?","Folic Acid","Oleic Acid","Pantothenic Acid","Ascorbic Acid","Oleic Acid"));
        list.add(new ModelClass("Which among the following plant is the most ancient source of anesthesia preparations?","Opium (poppy)","Cannabis","Datura","Coca","Opium (poppy)"));
        list.add(new ModelClass("What  is the average life of the Red Blood corpuscles?","100-120 days","120-140 days","80-95 days","70-85 days","100-120 days"));
        list.add(new ModelClass("The Study of Bryophytes & pteridophytes is known by Which terms?","Cytology","Mycology","Pomology","Bryology","Bryology"));

        list.add(new ModelClass("What type of reptiles are turtles?","Viviparous","Bisexual","Oviparous","Parthenogenic","Oviparous"));
        list.add(new ModelClass("Which nerves are attached to the brain and emerge from the skull?","Cranial Nerves","Spinal Nerves","Thoracic Nerves","Sacral Nerves","Cranial Nerves"));
        list.add(new ModelClass("What is the name of the only moving bone in the human skull?","Ethmoid bone","Nasal bone","Mandible bone","Lacrimal bone","Mandible bone"));
        list.add(new ModelClass("Which gland is also known as the third eye?","Adrenal glands","Pineal gland","Gonads","None of these","Pineal gland"));
        list.add(new ModelClass("Which of the following are examples of hydrophilic molecules?","sugar","cellulose","starch","All of the above","All of the above"));

        list.add(new ModelClass("Which one of following pairs was excluded from Whittaker's five kingdom classifications?","Algae and euglena","Lichens and algae","Euglena and viruses","Viruses and lichens","Viruses and lichens"));
        list.add(new ModelClass("Sacred groves found in several regions in India are an example of","ex situ conservation","In situ conservation","Reintroduction","restoration","In situ conservation"));
        list.add(new ModelClass("Which one of the following immune processes is most effectively controlled by anti-histamines?","Cell-mediated autoimmunity","IgE-mediated exaggerated immune response","IgG-mediated humoral immune response","IgM-mediated humoral immune response","IgE-mediated exaggerated immune response"));
        list.add(new ModelClass("According to the logistic population growth model, the growth rate is independent of","per capita birth rate","per capita death rate","Resource availability","environmental fluctuations","environmental fluctuations"));
        list.add(new ModelClass("Which one of the following microbial product is called clot buster?","Cyclosporin A","Paracetamol","Streptokinase","Statins","Streptokinase"));

        list.add(new ModelClass("Even after the brain of a frog has been crushed, it still responds to a pinch on the leg by drawing it away. This act is an example of","Conditioned reflex","Simple reflex","Automated motor response","Neurotransmitter induced response","Simple reflex"));
        list.add(new ModelClass("Find the incorrect statement about Volvox","Sexual reproduction is oogamous","true coelom and no metamerism","somatic cells are non flagellated","phototaxis movement is present","somatic cells are non flagellated"));
        list.add(new ModelClass("After trying for several years, a couple finally learnt that they are going to have a baby. They are experiencing this type of stress","Strain","Anxiety","Distress","Eustress","Eustress"));
        list.add(new ModelClass("The primary hormone responsible for stress-related physiological responses, such as an increase in heart rate is","epinephrine","insulin","cortisol","thyroxin","epinephrine"));
        list.add(new ModelClass("Marine phytoplankton is mostly represented by","Brown algae","Green algae","Sea weeds","Diatoms and Dinoflagellates","Diatoms and Dinoflagellates"));
    }

    public void geoQuiz()
    {
        list=new ArrayList<>();

        list.add(new ModelClass("Which from the following substance has the lowest albedo?","desert","snow","water","grass","water"));
        list.add(new ModelClass("The knot is a unit of speed equal to one nautical mile per hour and is equal to","1.252 km/h","1.452 km/h","1.652 km/h","1.852 km/h","1.852 km/h"));
        list.add(new ModelClass("The “Sisseri River Bridge” is recently in news is located in which of the following state?","Himachal Pradesh","Arunachal Pradesh","Uttar Pradesh","Madhya Pradesh","Arunachal Pradesh"));
        list.add(new ModelClass("The Buddha Nullah – is a seasonal stream often seen in news is located in which of the following state?","Punjab","Haryana","Rajasthan","Uttar Pradesh","Punjab"));
        list.add(new ModelClass("Which of the following river does not flow northwards?","Chambal River","Betwa River","Kosi River","Son River","Kosi River"));

        list.add(new ModelClass("Which of the following river rises north of the tropic of cancer in India?","Mahi River","Chambal River","Parbati River","Dhasan River","Dhasan River"));
        list.add(new ModelClass("The river Godavari is often referred to as Vridha Ganga because","it is the older river of India","of its large size and extent among the peninsular rivers","there are a fairly large number of pilgrimage centres situated on its banks","its length is nearly the same as that of the river Ganges","of its large size and extent among the peninsular rivers"));
        list.add(new ModelClass("The scarcity or crop failure of which of the following can cause a serious edible oil crisis in India?","coconut","Linseed","Groundnut","Mustard","Groundnut"));
        list.add(new ModelClass("The number of major ports in India is","5","8","15","13","13"));
        list.add(new ModelClass("Which of the following is a peninsular river of India?","Gandak","Kosi","Sutlej","Krishna","Krishna"));

        list.add(new ModelClass("Which of the following is the most important raw material for generation of power in India?","Coal","Mineral Oil","Natural Gas","Uranium","Coal"));
        list.add(new ModelClass("When it is noon IST at Allahabad in India, the time at Greenwich, London, will be", "midnight ,GMT","1730 hours","0630 hours","None of the above","0630 hours"));
        list.add(new ModelClass("Which country has the largest coast line?","USA","Canada","Australia","India","Canada"));
        list.add(new ModelClass("The two states of India, most richly endowed with iron ore, are","Madhya Pradesh and Orissa","Bihar and West Bengal","Madhya Pradesh and West Bengal","Bihar and Orissa","Bihar and Orissa"));
        list.add(new ModelClass("Which of the following crops is regarded as a plantation crop?","Coconut","Cotton","Sugarcane","Rice","Coconut"));

        list.add(new ModelClass("The most ideal region for the cultivation of cotton in India is","the Brahmaputra valley","the Indo-Gangetic valley","the Deccan plateau","the Rann of Kutch","the Deccan plateau"));
        list.add(new ModelClass("Which of the following important rivers of India does not originate from the Western Ghats?","Cauvery","Godavari","Krishna","Mahanadi","Mahanadi"));
        list.add(new ModelClass("International date line is a/an","Zigzag line","Straight line","Curved line","Elliptical line","Zigzag line"));
        list.add(new ModelClass("Boll-Weevil is a pest that attack the ________ crop","Jute","Cotton","Hemp","Flax","Cotton"));
        list.add(new ModelClass("Which country is known as the Emerald Isle?","Great Britain","Japan","New Zealand","Ireland","Ireland"));

    }


    private void hooks() {
        progressBar=findViewById(R.id.quiz_timer);
        card_question=findViewById(R.id.card_question);
        optiona=findViewById(R.id.optiona);
        optionb=findViewById(R.id.optionb);
        optionc=findViewById(R.id.optionc);
        optiond=findViewById(R.id.optiond);

        cardOA=findViewById(R.id.cardOA);
        cardOB=findViewById(R.id.cardOB);
        cardOC=findViewById(R.id.cardOC);
        cardOD=findViewById(R.id.cardOD);

        next_btn=findViewById(R.id.next_btn);
    }

//    public void correct(CardView cardView)
//    {
//        cardView.setBackgroundColor(getResources().getColor(R.color.green));
//
//        next_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                correctCount++;
//                index++;
//                modelClass=list.get(index);
//                resetColor();
//                setAllData();
//
//                //modified
//                enableButton();
//                next_btn.setClickable(false);
//
//                countDownTimer.cancel();
//                timerValue=20;
//                countDownTimer.start();
//
//
//            }
//        });
//
//
//
//    }


    public void correct(CardView cardView)
    {
        cardView.setBackgroundColor(getResources().getColor(R.color.green));
        next_btn.setBackgroundColor(getResources().getColor(R.color.secondary_quizx));
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                correctCount++;

                if(index<list.size()-1)
                {
                    index++;
                    modelClass=list.get(index);
                    resetColor();
                    setAllData();

                    //modified
                    enableButton();
                    next_btn.setClickable(false);
                    next_btn.setBackgroundColor(getResources().getColor(R.color.secondary_quizxlight));

                    countDownTimer.cancel();
                    timerValue=20;
                    countDownTimer.start();
                }
                else
                {
                    countDownTimer.cancel();
                    GameWon();
                }



            }
        });



    }




    public void  wrong(CardView cardView)
    {
        cardView.setBackgroundColor(getResources().getColor(R.color.red));
        next_btn.setBackgroundColor(getResources().getColor(R.color.secondary_quizx));
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                wrongCount++;
                if(index<list.size()-1)
                {

                    index++;
                    modelClass=list.get(index);
                    resetColor();
                    setAllData();

                    //modified
                    enableButton();
                    next_btn.setClickable(false);
                    next_btn.setBackgroundColor(getResources().getColor(R.color.secondary_quizxlight));

                    countDownTimer.cancel();
                    timerValue=20;
                    countDownTimer.start();

                }
                else
                {
                    countDownTimer.cancel();
                    GameWon();
                }
            }
        });

    }

    private void GameWon() {
        Intent i=new Intent(QuizMCQScreen.this,WonActivity.class);
        i.putExtra("correct",correctCount);
        i.putExtra("wrong",wrongCount);
        startActivity(i);
        finish();

    }

    public void enableButton()
    {
        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);
    }

    public void disableButton()
    {
        cardOA.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);
        cardOD.setClickable(false);

        cardOA.setBackgroundColor(getResources().getColor(R.color.grey));
        cardOB.setBackgroundColor(getResources().getColor(R.color.grey));
        cardOC.setBackgroundColor(getResources().getColor(R.color.grey));
        cardOD.setBackgroundColor(getResources().getColor(R.color.grey));
    }

    public  void resetColor()
    {
        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void optionAClick(View view) {
        disableButton();
        next_btn.setClickable(true);
        if(modelClass.getoA().equals(modelClass.getAns()))
        {


//            if(index<list.size()-1)
//            {
//                correct(cardOA);
//            }
//            else
//            {
//                GameWon();
//            }

            correct(cardOA);

        }
        else
        {
            wrong(cardOA);
        }

    }

    public void optionBClick(View view) {
        disableButton();
        next_btn.setClickable(true);
        if(modelClass.getoB().equals(modelClass.getAns()))
        {


//            if(index<list.size()-1)
//            {
//                correct(cardOB);
//            }
//            else
//            {
//                GameWon();
//            }
            correct(cardOB);

        }
        else
        {
            wrong(cardOB);
        }

    }

    public void optionCClick(View view) {
        disableButton();
        next_btn.setClickable(true);
        if(modelClass.getoC().equals(modelClass.getAns()))
        {


//            if(index<list.size()-1)
//            {
//                correct(cardOC);
//            }
//            else
//            {
//                GameWon();
//            }

            correct(cardOC);

        }
        else
        {
            wrong(cardOC);
        }

    }

    public void optionDClick(View view) {
        disableButton();
        next_btn.setClickable(true);
        if(modelClass.getoA().equals(modelClass.getAns()))
        {


//            if(index<list.size()-1)
//            {
//                correct(cardOD);
//            }
//            else
//            {
//                GameWon();
//            }

            correct(cardOD);

        }
        else
        {
            wrong(cardOD);
        }

    }


    public void back(View view)
    {
        countDownTimer.cancel();
        Intent i=new Intent(QuizMCQScreen.this,ChooseCategoryQuizScreen.class);
        startActivity(i);
        finish();
    }
}