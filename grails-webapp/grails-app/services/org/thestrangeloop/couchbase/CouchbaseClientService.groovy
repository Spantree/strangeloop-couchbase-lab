package org.thestrangeloop.couchbase

import com.couchbase.client.CouchbaseClient
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication

class CouchbaseClientService {
    DefaultGrailsApplication grailsApplication

    Map<String, CouchbaseClient> clients = [:]

    CouchbaseClient getClient(String bucketName = 'default', String password = '') {
        def config =  grailsApplication.config.couchbase
        if(!config) {
            log.warn "No couchbase config defined"
        } else {
            if(clients[bucketName] == null) {
                List<URI> hostUris = []
                config.hosts?.each { hostString ->
                    hostUris << new URI("${hostString}/pools")
                }
                clients[bucketName] = new CouchbaseClient(hostUris, bucketName, password)
            }
        }
        clients[bucketName]
    }
}
