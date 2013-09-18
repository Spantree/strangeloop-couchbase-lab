node default {
  class { 'couchbase::server':
    version => '2.2.0'
  }
}