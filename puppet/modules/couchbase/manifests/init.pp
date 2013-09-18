class couchbase::server(
  $version = '2.2.0'
) {
  $deb_file = "couchbase-server-enterprise_${version}_x86_64.deb"

  wget::fetch { "fetch-couchbase":
	source => "http://packages.couchbase.com/releases/${version}/${deb_file}",
	destination => "/usr/src/${deb_file}",
	verbose => true
  }

  package { "couchbase":
    provider => dpkg,
    ensure   => latest,
    source   => "/usr/src/${deb_file}",
    require	 => Wget::Fetch["fetch-couchbase"]
  }
}