import StackLinkedList from "./StackLinkedList";

describe("StackLinkedList", () => {
  let stackLinkedList;
  beforeEach(() => {
    stackLinkedList = new StackLinkedList();
  });

  describe("isEmpty", () => {
    it("on init", () => {
      expect(stackLinkedList.isEmpty()).toEqual(true);
    });

    it("is false after a push operation", () => {
      stackLinkedList.push("foo");
      expect(stackLinkedList.isEmpty()).toEqual(false);
    });
  });

  describe("Integration", () => {
    it("verifies the end state", () => {
      stackLinkedList.push("to");
      stackLinkedList.push("be");
      stackLinkedList.push("or");
      stackLinkedList.push("not");
      stackLinkedList.push("to");
      expect(stackLinkedList.pop()).toEqual("to");
      stackLinkedList.push("be");
      expect(stackLinkedList.pop()).toEqual("be");
      expect(stackLinkedList.pop()).toEqual("not");
      stackLinkedList.push("that");
      expect(stackLinkedList.pop()).toEqual("that");
      expect(stackLinkedList.pop()).toEqual("or");
      expect(stackLinkedList.pop()).toEqual("be");
      stackLinkedList.push("is");
    });
  });
});
