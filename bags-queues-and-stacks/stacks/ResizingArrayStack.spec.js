import ResizingArrayStack from "./ResizingArrayStack";

describe("ResizingArrayStack", () => {
  let resizingArrayStack;
  beforeEach(() => {
    resizingArrayStack = new ResizingArrayStack();
  });

  describe("isEmpty", () => {
    it("on init", () => {
      expect(resizingArrayStack.isEmpty()).toEqual(true);
    });

    it("is false after a push operation", () => {
      resizingArrayStack.push("foo");
      expect(resizingArrayStack.isEmpty()).toEqual(false);
    });
  });

  describe("Integration", () => {
    it("verifies the end state", () => {
      resizingArrayStack.push("to");
      resizingArrayStack.push("be");
      resizingArrayStack.push("or");
      resizingArrayStack.push("not");
      resizingArrayStack.push("to");
      expect(resizingArrayStack.pop()).toEqual("to");
      resizingArrayStack.push("be");
      expect(resizingArrayStack.pop()).toEqual("be");
      expect(resizingArrayStack.pop()).toEqual("not");
      resizingArrayStack.push("that");
      expect(resizingArrayStack.pop()).toEqual("that");
      expect(resizingArrayStack.pop()).toEqual("or");
      expect(resizingArrayStack.pop()).toEqual("be");
      resizingArrayStack.push("is");
    });
  });
});
