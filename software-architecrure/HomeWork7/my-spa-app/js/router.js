class Router {
    constructor() {
        this.routes = {};
    }

    register(route, callback) {
        this.routes[route] = callback;
    }

    navigate(route) {
        if (this.routes[route]) {
            this.routes[route]();
        } else {
            this.routes['#404']();
        }
    }
}

const router = new Router();

