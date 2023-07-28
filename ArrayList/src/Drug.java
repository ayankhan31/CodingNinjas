public class Drug {
    String drug_name, disease_treated;
    Drug(){
        this.drug_name = "";
        this.disease_treated = "";
    }
}

class sedative extends Drug{
    protected String side_effects;
    sedative(){
        super();
        side_effects = "";
    }
    public void print(){
        System.out.println("Name: "+this.drug_name+ " Side Effect "+ this.side_effects);
    }
    public void setSide_effects(String s){
        this.side_effects = s;
    }
}

class non_sedative extends  Drug{
    String side_effects;
    non_sedative(){
        super();
        side_effects = "";
    }
    public void print(){
        System.out.println("Name: "+this.drug_name+ " Side Effect"+ this.side_effects);
    }
    public void setSide_effects(String s){
        this.side_effects = s;
    }
}