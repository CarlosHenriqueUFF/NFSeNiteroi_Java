/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webiss.niteroi.nfse.util;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
import java.io.InputStream;
import java.io.InputStreamReader;

import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

public class LSResourceResolverImpl implements LSResourceResolver {

    @Override
    public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {

        LSInputImpl input = new LSInputImpl();
        System.out.println("system id");
        System.out.println(systemId);
        InputStream stream = getClass().getClassLoader().getResourceAsStream("resources/xmldsig-core-schema20020212.xsd");
        System.out.println("stream");
        System.out.println(stream);
        
        input.setPublicId(publicId);
        input.setSystemId(systemId);
        input.setBaseURI(baseURI);
        input.setCharacterStream(new InputStreamReader(stream));

        return input;
    }
}
