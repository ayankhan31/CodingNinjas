public class DrugUse {

    public static void Search(String Disease, Drug d){
        System.out.println(d.drug_name+" treats "+ Disease);
    }

    public static void findDrug(String sideeffects, Drug d){
        System.out.println("Side-effect : "+ sideeffects+ ", Drug : "+d.drug_name);
    }
    public static void main(String[] args) {
        sedative s1 = new sedative();
        s1.drug_name = "Chlorophenamine";
        s1.setSide_effects("Dizziness");
        s1.disease_treated = "Allergy";
        sedative s2 = new sedative();
        s2.drug_name = "Alpraxolam";
        s2.setSide_effects("Being forgetful");
        s2.disease_treated = "Depression";
        sedative s3 = new sedative();
        non_sedative ns1 = new non_sedative();
        ns1.drug_name = "Cetrizine";
        ns1.setSide_effects("HeadAches");
        ns1.disease_treated = "Allergy";
        non_sedative ns2 = new non_sedative();
        ns2.drug_name = "Imipramine";
        ns2.setSide_effects("nausea");
        ns2.disease_treated = "Depression";

        s1.print();
        System.out.println();
        s2.print();
        System.out.println();
        Search(s1.side_effects,s1);
        System.out.println();
        Search(s2.disease_treated, s2);
        System.out.println();
        findDrug(s1.side_effects,s1);
        System.out.println();
        findDrug(s2.side_effects,s2);
        System.out.println();
        Search(ns1.disease_treated,ns1);
        System.out.println();
        Search(ns2.disease_treated, ns2);
        System.out.println();
        findDrug(ns2.side_effects,ns2);
        System.out.println();

    }
}
