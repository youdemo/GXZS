/**
 * JSGX_MDM_MATERIALLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package JSGX_MDM_MATERIALWsd;

public class JSGX_MDM_MATERIALLocator extends org.apache.axis.client.Service implements JSGX_MDM_MATERIALWsd.JSGX_MDM_MATERIAL {

    public JSGX_MDM_MATERIALLocator() {
    }


    public JSGX_MDM_MATERIALLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public JSGX_MDM_MATERIALLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HTTPNonePort
    private java.lang.String HTTPNonePort_address = "http://JSGXPOPSCS:8000/JSGX_MDM_MATERIAL/HTTPNone?style=document";

    public java.lang.String getHTTPNonePortAddress() {
        return HTTPNonePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HTTPNonePortWSDDServiceName = "HTTPNonePort";

    public java.lang.String getHTTPNonePortWSDDServiceName() {
        return HTTPNonePortWSDDServiceName;
    }

    public void setHTTPNonePortWSDDServiceName(java.lang.String name) {
        HTTPNonePortWSDDServiceName = name;
    }

    public JSGX_MDM_MATERIALWsd.JSGX_MDM_MATERIALVi getHTTPNonePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HTTPNonePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHTTPNonePort(endpoint);
    }

    public JSGX_MDM_MATERIALWsd.JSGX_MDM_MATERIALVi getHTTPNonePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            JSGX_MDM_MATERIALWsd.HTTPNoneBindingStub _stub = new JSGX_MDM_MATERIALWsd.HTTPNoneBindingStub(portAddress, this);
            _stub.setPortName(getHTTPNonePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHTTPNonePortEndpointAddress(java.lang.String address) {
        HTTPNonePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (JSGX_MDM_MATERIALWsd.JSGX_MDM_MATERIALVi.class.isAssignableFrom(serviceEndpointInterface)) {
                JSGX_MDM_MATERIALWsd.HTTPNoneBindingStub _stub = new JSGX_MDM_MATERIALWsd.HTTPNoneBindingStub(new java.net.URL(HTTPNonePort_address), this);
                _stub.setPortName(getHTTPNonePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("HTTPNonePort".equals(inputPortName)) {
            return getHTTPNonePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:JSGX_MDM_MATERIALWsd", "JSGX_MDM_MATERIAL");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:JSGX_MDM_MATERIALWsd", "HTTPNonePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HTTPNonePort".equals(portName)) {
            setHTTPNonePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
