package com.cbrl.couchbase.demo.infra.adapters.jpa.repository;

import com.cbrl.couchbase.demo.infra.adapters.jpa.document.UserDocument;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

public interface UserRepository extends CouchbaseRepository<UserDocument, String> {

}
