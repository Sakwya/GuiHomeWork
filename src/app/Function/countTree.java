package app.Function;

abstract class countTree {
    double count() {
        System.out.println("Error");
        return 0;
    }

}

class numT extends countTree {
    double data;

    @Override
    public double count() {
        return data;
    }

    numT(double num) {
        data = num;
    }
}

class eT extends countTree {
    @Override
    public double count() {
        return Math.E;
    }
}

class piT extends countTree {
    @Override
    public double count() {
        return Math.PI;
    }
}

class addT extends countTree {
    final countTree a, b;

    @Override
    public double count() {
        return a.count() + b.count();
    }

    addT(countTree a, countTree b) {
        this.a = a;
        this.b = b;
    }
}

class subT extends countTree {
    final countTree a, b;

    @Override
    public double count() {
        return a.count() - b.count();
    }

    subT(countTree a, countTree b) {
        this.a = a;
        this.b = b;
    }
}

class mulT extends countTree {
    final countTree a, b;

    @Override
    public double count() {
        return a.count() * b.count();
    }

    mulT(countTree a, countTree b) {
        this.a = a;
        this.b = b;
    }
}

class divT extends countTree {
    final countTree a, b;

    @Override
    public double count() {
        return a.count() / b.count();
    }

    divT(countTree a, countTree b) {
        this.a = a;
        this.b = b;

    }
}

class powT extends countTree {

    final countTree a, b;

    @Override
    public double count() {
        return Math.pow(a.count(), b.count());
    }

    powT(countTree a, countTree b) {
        this.a = a;
        this.b = b;
    }
}

class logT extends countTree {

    final countTree a, b;

    @Override
    public double count() {
        return Math.log(b.count()) / Math.log(a.count());
    }

    logT(countTree a, countTree b) {
        this.a = a;
        this.b = b;

    }
}

class sinT extends countTree {
    final countTree a;

    @Override
    public double count() {
        return Math.sin(a.count());
    }

    sinT(countTree a) {
        this.a = a;
    }
}

class cosT extends countTree {

    final countTree a;

    @Override
    public double count() {
        return Math.cos(a.count());
    }

    cosT(countTree a) {
        this.a = a;
    }
}

class tanT extends countTree {
    final countTree a;

    @Override
    public double count() {
        return Math.tan(a.count());
    }

    tanT(countTree a) {
        this.a = a;
    }
}

class arc_sinT extends countTree {
    final countTree a;

    @Override
    public double count() {
        return Math.asin(a.count());
    }

    arc_sinT(countTree a) {
        this.a = a;
    }
}

class arc_cosT extends countTree {
    final countTree a;

    @Override
    public double count() {
        return Math.acos(a.count());
    }

    arc_cosT(countTree a) {
        this.a = a;
    }
}

class arc_tanT extends countTree {
    final countTree a;

    @Override
    public double count() {
        return Math.atan(a.count());
    }

    arc_tanT(countTree a) {
        this.a = a;
    }
}