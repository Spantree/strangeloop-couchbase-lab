class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        '/users/'(controller: 'user', action: 'index')
        "/users/${id}"(controller: 'user') {
            action = [GET: 'edit', POST: 'save']
        }

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
