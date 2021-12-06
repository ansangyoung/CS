// C:\gitWorkspace\privateCS2\bin\ch7
package ch7;

class InnerEx6 {
	// 익명클래스
	Object iv = new Object() {
		void method() {
		}
	};

	// 익명클래스
	static Object cv = new Object() {
		void method() {
		}
	};

	// 익명클래스
	void MyMethod() {
		Object lv = new Object() {
			void method() {
			}
		};
	}
}