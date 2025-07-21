
package default_package;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the default_package package. 
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

    private final static QName _RegistarUser_QNAME = new QName("http://default_package/", "RegistarUser");
    private final static QName _RegistarUserResponse_QNAME = new QName("http://default_package/", "RegistarUserResponse");
    private final static QName _CancelarConsulta_QNAME = new QName("http://default_package/", "cancelarConsulta");
    private final static QName _CancelarConsultaResponse_QNAME = new QName("http://default_package/", "cancelarConsultaResponse");
    private final static QName _ListarConsultas_QNAME = new QName("http://default_package/", "listarConsultas");
    private final static QName _ListarConsultasResponse_QNAME = new QName("http://default_package/", "listarConsultasResponse");
    private final static QName _LoginUser_QNAME = new QName("http://default_package/", "loginUser");
    private final static QName _LoginUserResponse_QNAME = new QName("http://default_package/", "loginUserResponse");
    private final static QName _ReservarConsulta_QNAME = new QName("http://default_package/", "reservarConsulta");
    private final static QName _ReservarConsultaResponse_QNAME = new QName("http://default_package/", "reservarConsultaResponse");
    private final static QName _UpdateConsulta_QNAME = new QName("http://default_package/", "updateConsulta");
    private final static QName _UpdateConsultaResponse_QNAME = new QName("http://default_package/", "updateConsultaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: default_package
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegistarUser }
     * 
     */
    public RegistarUser createRegistarUser() {
        return new RegistarUser();
    }

    /**
     * Create an instance of {@link RegistarUserResponse }
     * 
     */
    public RegistarUserResponse createRegistarUserResponse() {
        return new RegistarUserResponse();
    }

    /**
     * Create an instance of {@link CancelarConsulta }
     * 
     */
    public CancelarConsulta createCancelarConsulta() {
        return new CancelarConsulta();
    }

    /**
     * Create an instance of {@link CancelarConsultaResponse }
     * 
     */
    public CancelarConsultaResponse createCancelarConsultaResponse() {
        return new CancelarConsultaResponse();
    }

    /**
     * Create an instance of {@link ListarConsultas }
     * 
     */
    public ListarConsultas createListarConsultas() {
        return new ListarConsultas();
    }

    /**
     * Create an instance of {@link ListarConsultasResponse }
     * 
     */
    public ListarConsultasResponse createListarConsultasResponse() {
        return new ListarConsultasResponse();
    }

    /**
     * Create an instance of {@link LoginUser }
     * 
     */
    public LoginUser createLoginUser() {
        return new LoginUser();
    }

    /**
     * Create an instance of {@link LoginUserResponse }
     * 
     */
    public LoginUserResponse createLoginUserResponse() {
        return new LoginUserResponse();
    }

    /**
     * Create an instance of {@link ReservarConsulta }
     * 
     */
    public ReservarConsulta createReservarConsulta() {
        return new ReservarConsulta();
    }

    /**
     * Create an instance of {@link ReservarConsultaResponse }
     * 
     */
    public ReservarConsultaResponse createReservarConsultaResponse() {
        return new ReservarConsultaResponse();
    }

    /**
     * Create an instance of {@link UpdateConsulta }
     * 
     */
    public UpdateConsulta createUpdateConsulta() {
        return new UpdateConsulta();
    }

    /**
     * Create an instance of {@link UpdateConsultaResponse }
     * 
     */
    public UpdateConsultaResponse createUpdateConsultaResponse() {
        return new UpdateConsultaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistarUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistarUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "RegistarUser")
    public JAXBElement<RegistarUser> createRegistarUser(RegistarUser value) {
        return new JAXBElement<RegistarUser>(_RegistarUser_QNAME, RegistarUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistarUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistarUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "RegistarUserResponse")
    public JAXBElement<RegistarUserResponse> createRegistarUserResponse(RegistarUserResponse value) {
        return new JAXBElement<RegistarUserResponse>(_RegistarUserResponse_QNAME, RegistarUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelarConsulta }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelarConsulta }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "cancelarConsulta")
    public JAXBElement<CancelarConsulta> createCancelarConsulta(CancelarConsulta value) {
        return new JAXBElement<CancelarConsulta>(_CancelarConsulta_QNAME, CancelarConsulta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelarConsultaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelarConsultaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "cancelarConsultaResponse")
    public JAXBElement<CancelarConsultaResponse> createCancelarConsultaResponse(CancelarConsultaResponse value) {
        return new JAXBElement<CancelarConsultaResponse>(_CancelarConsultaResponse_QNAME, CancelarConsultaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarConsultas }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarConsultas }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "listarConsultas")
    public JAXBElement<ListarConsultas> createListarConsultas(ListarConsultas value) {
        return new JAXBElement<ListarConsultas>(_ListarConsultas_QNAME, ListarConsultas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarConsultasResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarConsultasResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "listarConsultasResponse")
    public JAXBElement<ListarConsultasResponse> createListarConsultasResponse(ListarConsultasResponse value) {
        return new JAXBElement<ListarConsultasResponse>(_ListarConsultasResponse_QNAME, ListarConsultasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoginUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "loginUser")
    public JAXBElement<LoginUser> createLoginUser(LoginUser value) {
        return new JAXBElement<LoginUser>(_LoginUser_QNAME, LoginUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoginUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "loginUserResponse")
    public JAXBElement<LoginUserResponse> createLoginUserResponse(LoginUserResponse value) {
        return new JAXBElement<LoginUserResponse>(_LoginUserResponse_QNAME, LoginUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservarConsulta }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReservarConsulta }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "reservarConsulta")
    public JAXBElement<ReservarConsulta> createReservarConsulta(ReservarConsulta value) {
        return new JAXBElement<ReservarConsulta>(_ReservarConsulta_QNAME, ReservarConsulta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservarConsultaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReservarConsultaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "reservarConsultaResponse")
    public JAXBElement<ReservarConsultaResponse> createReservarConsultaResponse(ReservarConsultaResponse value) {
        return new JAXBElement<ReservarConsultaResponse>(_ReservarConsultaResponse_QNAME, ReservarConsultaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateConsulta }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateConsulta }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "updateConsulta")
    public JAXBElement<UpdateConsulta> createUpdateConsulta(UpdateConsulta value) {
        return new JAXBElement<UpdateConsulta>(_UpdateConsulta_QNAME, UpdateConsulta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateConsultaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateConsultaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "updateConsultaResponse")
    public JAXBElement<UpdateConsultaResponse> createUpdateConsultaResponse(UpdateConsultaResponse value) {
        return new JAXBElement<UpdateConsultaResponse>(_UpdateConsultaResponse_QNAME, UpdateConsultaResponse.class, null, value);
    }

}
