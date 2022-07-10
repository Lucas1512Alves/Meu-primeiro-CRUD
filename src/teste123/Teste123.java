package teste123;

import dao.Daopassageiro;
import model.Passageiro;
import util.EntityManagerUtil;

public class Teste123 {

    public static void main(String[] args) throws Exception {
        
         Daopassageiro daoPassageiro = new Daopassageiro(EntityManagerUtil.getEntityManagerFactory());
         Passageiro passageiro1 = daoPassageiro.findPassageiro(1);
         System.out.println(passageiro1.getCodpassageiro());
    }
    
}
