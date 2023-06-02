package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Colaborador;
import model.Veiculo;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-02T09:47:37")
@StaticMetamodel(Servico.class)
public class Servico_ { 

    public static volatile SingularAttribute<Servico, String> tipoServico;
    public static volatile SingularAttribute<Servico, Integer> idServico;
    public static volatile SingularAttribute<Servico, Colaborador> email;
    public static volatile SingularAttribute<Servico, Float> valorServ;
    public static volatile SingularAttribute<Servico, String> dataServico;
    public static volatile SingularAttribute<Servico, Veiculo> placa;

}