package com.research.demo.logger.layout;

import com.research.demo.logger.LoggingEvent;
import com.research.demo.logger.layout.pattern.Node;
import com.research.demo.logger.layout.pattern.PatternParser;

import java.util.List;

/**
 * 可配置的字符串模板布局
 */
public class PatternLayout implements Layout {

    private String pattern;

    private PatternParser patternParser;

    private List<Node> nodes;

    @Override
    public String doLayout(LoggingEvent e) {
        StringBuilder sb = new StringBuilder();
        for (Node n : nodes) {
            sb.append(n.getConverter().convert(e));
        }
        return sb.toString();
    }



    public void setPattern(String pattern) {
        this.pattern = pattern;

    }

    private void prepare(){
        this.patternParser = new PatternParser(pattern);
        this.nodes = patternParser.parse();
    }

    @Override
    public void start() {
        prepare();
    }

    @Override
    public void stop() {

    }
}
