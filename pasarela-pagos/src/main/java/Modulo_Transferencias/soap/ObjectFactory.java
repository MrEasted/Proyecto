
package Modulo_Transferencias.soap;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the interfaces.ws.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Deposito_QNAME = new QName("http://soap.ws.Interfaces/", "deposito");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: interfaces.ws.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Deposito }
     * 
     * @return
     *     the new instance of {@link Deposito }
     */
    public Deposito createDeposito() {
        return new Deposito();
    }

    /**
     * Create an instance of {@link Resultado }
     * 
     * @return
     *     the new instance of {@link Resultado }
     */
    public Resultado createResultado() {
        return new Resultado();
    }

    /**
     * Create an instance of {@link DepositoArray }
     * 
     * @return
     *     the new instance of {@link DepositoArray }
     */
    public DepositoArray createDepositoArray() {
        return new DepositoArray();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deposito }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Deposito }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.ws.Interfaces/", name = "deposito")
    public JAXBElement<Deposito> createDeposito(Deposito value) {
        return new JAXBElement<>(_Deposito_QNAME, Deposito.class, null, value);
    }

}
