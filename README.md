#### Background

This is a puppet/vagrant configuration for [Matt Ingenthron's](http://blog.couchbase.com/matt) NoSQL Couchbase Workshop at [Strangeloop 2013](https://thestrangeloop.com/schedule).

It creates an Ubuntu 12.04 x64 Linux image and preinstalls [Couchbase 2.2.0 EE](http://www.couchbase.com/download), which can be accessed from the host system.

#### Tools You'll Need

Install the following tools to bootstrap your environment

* Install [Git](https://help.github.com/articles/set-up-git)
* Install [VirtualBox](https://www.virtualbox.org/)
* Install [Vagrant](http://www.vagrantup.com/)

#### Clone this repository

From the command line, clone this repository with:

```bash
git clone --recursive git@github.com:Spantree/strangeloop-couchbase-lab.git
```

If you're new to git and run into trouble with this step, it might be due to missing 
[github keys](https://help.github.com/articles/generating-ssh-keys).

#### Set up your vagrant instance

Then initialize your vagrant instance with:

```bash
cd strangeloop-couchbase-talk
vagrant up
```

#### Access the Couchbase Server

Once the vagrant instance has started, you should be able to access Couchbase at http://192.168.210.100:8091.

![Screenshot](http://images.spantree.net.s3.amazonaws.com/Couchbase_Console_%282.2.0%29-20130918-093400.jpg)
