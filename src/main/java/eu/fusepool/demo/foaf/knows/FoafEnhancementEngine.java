package eu.fusepool.demo.foaf.knows;


import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.apache.clerezza.rdf.core.LiteralFactory;
import org.apache.clerezza.rdf.core.MGraph;
import org.apache.clerezza.rdf.core.UriRef;
import org.apache.clerezza.rdf.core.impl.TripleImpl;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.stanbol.enhancer.servicesapi.ContentItem;
import org.apache.stanbol.enhancer.servicesapi.EngineException;
import org.apache.stanbol.enhancer.servicesapi.EnhancementEngine;
import org.apache.stanbol.enhancer.servicesapi.ServiceProperties;
import org.apache.stanbol.enhancer.servicesapi.impl.AbstractEnhancementEngine;
import org.osgi.framework.Constants;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, metatype = true)
@Service
@Properties(value={
     @Property(name=EnhancementEngine.PROPERTY_NAME, value="demoEngine"),
     @Property(name=Constants.SERVICE_RANKING,intValue=FoafEnhancementEngine.DEFAULT_SERVICE_RANKING)
})
public class FoafEnhancementEngine 
        extends AbstractEnhancementEngine<IOException,RuntimeException> 
        implements EnhancementEngine, ServiceProperties {

    public static final String DEFAULT_ENGINE_NAME = "foafknows";
    /**
     * Default value for the {@link Constants#SERVICE_RANKING} used by this engine.
     * This is a negative value to allow easy replacement by this engine depending
     * to a remote service with one that does not have this requirement
     */
    public static final int DEFAULT_SERVICE_RANKING = 100;
    /**
     * The default value for the Execution of this Engine. Currently set to
     * {@link ServiceProperties#ORDERING_EXTRACTION_ENHANCEMENT}
     */
    public static final Integer defaultOrder = ORDERING_EXTRACTION_ENHANCEMENT;

   
    private static final Logger log = LoggerFactory.getLogger(FoafEnhancementEngine.class);

   

    private Integer maxLocationEnhancements;
    private Double minScore;
    private Double minHierarchyScore;

    @SuppressWarnings("unchecked")
    protected void activate(ComponentContext ce) throws IOException, ConfigurationException {
        super.activate(ce);
         log.info("activating ...");
      
    }

    protected void deactivate(ComponentContext ce) {
        super.deactivate(ce);
    }

    @Override
    public int canEnhance(ContentItem ci) throws EngineException {
        return ENHANCE_SYNCHRONOUS;
    }

    @Override
    public void computeEnhancements(ContentItem ci) throws EngineException {
        UriRef contentItemId = ci.getUri();
        MGraph graph = ci.getMetadata();
        LiteralFactory literalFactory = LiteralFactory.getInstance();
        graph.add(new TripleImpl(contentItemId,
                new UriRef("http://example.org/likes"), 
                new UriRef("http://fusepool.eu")));
    }

    @Override
    public Map<String, Object> getServiceProperties() {
        return Collections.unmodifiableMap(Collections.singletonMap(
                ENHANCEMENT_ENGINE_ORDERING, (Object) defaultOrder));
    }

}
