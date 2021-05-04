package com.cbrl.couchbase.demo.infra.common.couchbase.configuration;

import com.cbrl.couchbase.demo.infra.adapters.jpa.document.UserDocument;
import com.couchbase.client.java.Cluster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.CouchbaseClientFactory;
import org.springframework.data.couchbase.SimpleCouchbaseClientFactory;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.convert.MappingCouchbaseConverter;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;

@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.cbrl.couchbase.demo.infra.adapters.jpa.repository"})
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {
    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "Administrator";
    }

    @Override
    public String getPassword() {
        return "Administrator";
    }

    @Override
    public String getBucketName() {
        return "test";
    }

    @Bean
    public CouchbaseTemplate myCouchbaseTemplate(CouchbaseClientFactory myCouchbaseClientFactory,
                                                 MappingCouchbaseConverter mappingCouchbaseConverter) {
        return new CouchbaseTemplate(myCouchbaseClientFactory, mappingCouchbaseConverter);
    }

    @Bean
    public CouchbaseClientFactory myCouchbaseClientFactory(Cluster couchbaseCluster) {

        return new SimpleCouchbaseClientFactory(couchbaseCluster, getBucketName(), getScopeName());
    }

    @Override
    protected void configureRepositoryOperationsMapping(RepositoryOperationsMapping mapping) {


        CouchbaseTemplate empTemplate = couchbaseTemplate(
                couchbaseClientFactory(couchbaseCluster(couchbaseClusterEnvironment())),
                new MappingCouchbaseConverter());

        mapping.mapEntity(UserDocument.class,  empTemplate);


    }
}
