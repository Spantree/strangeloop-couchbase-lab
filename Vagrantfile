# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  config.vm.box = "strangeloop"
  config.vm.box_url = "http://files.vagrantup.com/precise64.box"

  config.vm.define :db do |db|
    db.vm.hostname = "db.couchbase.strangeloop.local"
    db.vm.network :private_network, ip: "192.168.210.100"
    db.vm.provider "virtualbox" do |v|
      v.customize ["modifyvm", :id, "--memory", 1500]
    end
    db.vm.provision :puppet do |puppet|
      puppet.manifests_path = "puppet/manifests"
      puppet.module_path    = "puppet/modules"
      puppet.manifest_file = "site.pp"
      puppet.facter = {
        "host_environment" => "Vagrant"
      }
      puppet.options = "--verbose --debug"
    end
  end
end
