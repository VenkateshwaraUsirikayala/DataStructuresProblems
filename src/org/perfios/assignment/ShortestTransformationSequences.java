package org.perfios.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestTransformationSequences {
	public List<List<String>> transformationSequences(String startWord, String endWord, List<String> wordsList) {
		List<List<String>> allPath = new ArrayList();
		List<String> path = new ArrayList<String>();

		path.add(startWord);
		List<String> visited = new ArrayList<String>();
		visited.add(startWord);

		useDfs(startWord, endWord, wordsList, allPath, path, visited);

		List<List<String>> result = new ArrayList();
		for (List<String> list : allPath) {
			int size = result.size();
			if (size == 0)
				result.add(list);
			else if (result.get(size - 1).size() > list.size()) {
				result.clear();
				result.add(list);
			} else if (result.get(size - 1).size() == list.size()) {
				result.add(list);
			}
		}

		return result;
	}

	public void useDfs(String word, String endWord, List<String> wordsList, List<List<String>> allPaths, List<String> path, List<String> visited) {

		char[] wordArray = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			char character = wordArray[i];
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (ch != character) {
					wordArray[i] = ch;
					String newWord = new String(wordArray);

					if (newWord.equals(endWord)) {
						List<String> temp = new ArrayList<String>();
						temp.addAll(path);
						temp.add(endWord);
						allPaths.add(temp);
						return;
					}

					if (wordsList.contains(newWord) && !visited.contains(newWord)) {
						path.add(newWord);
						visited.add(newWord);
						useDfs(newWord, endWord, wordsList, allPaths, path, visited);
						path.remove(path.size() - 1);
						visited.remove(visited.size() - 1);
					}
				}
			}
			wordArray[i] = character;
		}
	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		ShortestTransformationSequences transformationSequences = new ShortestTransformationSequences();
		List<List<String>> ladders = transformationSequences.transformationSequences(beginWord, endWord, wordList);
		for (List<String> list : ladders) {
			System.out.println(list);
		}
	}
}