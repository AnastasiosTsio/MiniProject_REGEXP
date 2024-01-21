package info3.regexp;

public class Test_Regexp {

	public static void main(String[] args) {

		// OPTIONS
		String output_path = "output/reg/";
		Regexp.AUTOMATON = true;
		Regexp.THOMPSON_OPTIMISATION = false;

		Symbol nil = Symbol.EMPTY;
		nil.export(output_path, nil.name());

		Symbol eps = Symbol.EPSILON_REGEXP;
		eps.export(output_path, "eps");

		Symbol a = new Symbol("a");
		a.export(output_path, a.name());

		Symbol b = new Symbol("b");
		b.export(output_path, b.name());

		Symbol c = new Symbol("c");
		c.export(output_path, c.name());

		Concat c0 = new Concat();
		c0.export(output_path, "c0");

		Sum s0 = new Sum();
		s0.export(output_path, "s0");

		Concat c3 = new Concat();
		c3.add(a);
		c3.add(b);
		c3.add(c);
		c3.export(output_path, "c3");

		Sum s3 = new Sum();
		s3.add(a);
		s3.add(b);
		s3.add(c);
		s3.export(output_path, "s3");

		Star ks0 = new Star(s0);
		ks0.export(output_path, "ks0");

		Star kc0 = new Star(c0);
		kc0.export(output_path, "kc0");

		Star keps = new Star(eps);
		keps.export(output_path, "keps");

		Star ks1 = new Star(a);
		ks1.export(output_path, "ks1");

		Star ks3 = new Star(s3);
		ks3.export(output_path, "ks3");

		Star kc3 = new Star(c3);
		kc3.export(output_path, "kc3");

		Star kkc1 = new Star(kc3);
		kkc1.export(output_path, "kkc1");

		Concat cs3 = new Concat();
		cs3.add(s3);
		cs3.add(s3);
		cs3.add(s3);
		cs3.export(output_path, "cs3");

		Concat cc3 = new Concat();
		cc3.add(c3);
		cc3.add(c3);
		cc3.add(c3);
		cc3.export(output_path, "cc3");

		Concat ccsc = new Concat();
		ccsc.add(c3);
		ccsc.add(s3);
		ccsc.add(c3);
		ccsc.export(output_path, "ccsc");

		Concat cscs = new Concat();
		cscs.add(s3);
		cscs.add(c3);
		cscs.add(s3);
		cscs.export(output_path, "cscs");

		Sum sc3 = new Sum();
		sc3.add(c3);
		sc3.add(c3);
		sc3.add(c3);
		sc3.export(output_path, "sc3");

		Sum ss3 = new Sum();
		ss3.add(s3);
		ss3.add(s3);
		ss3.add(s3);
		ss3.export(output_path, "ss3");
	}
}